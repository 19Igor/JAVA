/*
 * Copyright (c) 2009, 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/*
 * This file was originally generated by JSLC
 * and then hand edited for performance.
 */

package com.sun.scenario.effect.impl.sw.sse;

import java.nio.FloatBuffer;

import com.sun.scenario.effect.FilterContext;
import com.sun.scenario.effect.ImageData;
import com.sun.scenario.effect.Effect;
import com.sun.scenario.effect.impl.HeapImage;
import com.sun.scenario.effect.impl.Renderer;
import com.sun.javafx.geom.Rectangle;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.scenario.effect.impl.state.LinearConvolveRenderState;
import com.sun.scenario.effect.impl.state.LinearConvolveRenderState.PassType;

public class SSELinearConvolvePeer extends SSEEffectPeer<LinearConvolveRenderState> {

    public SSELinearConvolvePeer(FilterContext fctx, Renderer r, String uniqueName) {
        super(fctx, r, uniqueName);
    }

    @Override
    public ImageData filter(Effect effect,
                            LinearConvolveRenderState lcrstate,
                            BaseTransform transform,
                            Rectangle outputClip,
                            ImageData... inputs) {
        setRenderState(lcrstate);
        Rectangle inputBounds = inputs[0].getTransformedBounds(null);
        // If the non-VECTOR loops below could handle clipped output, then
        // we would not need to call getPassResultBounds twice (RT-27406)
        Rectangle dstRawBounds = lcrstate.getPassResultBounds(inputBounds, null);
        Rectangle dstBounds = lcrstate.getPassResultBounds(inputBounds, outputClip);
        setDestBounds(dstBounds);
        int dstw = dstBounds.width;
        int dsth = dstBounds.height;

        // NOTE: for now, all input images must be TYPE_INT_ARGB_PRE
        HeapImage src = (HeapImage) inputs[0].getUntransformedImage();
        int srcw = src.getPhysicalWidth();
        int srch = src.getPhysicalHeight();
        int srcscan = src.getScanlineStride();
        int[] srcPixels = src.getPixelArray();

        Rectangle src0Bounds = inputs[0].getUntransformedBounds();
        BaseTransform src0Transform = inputs[0].getTransform();
        Rectangle src0NativeBounds = new Rectangle(0, 0, srcw, srch);
        // Assert: rstate.getEffectTransformSpace() == UserSpace
        setInputBounds(0, src0Bounds);
        setInputTransform(0, src0Transform);
        setInputNativeBounds(0, src0NativeBounds);

        HeapImage dst = (HeapImage) getRenderer().getCompatibleImage(dstw, dsth);
        setDestNativeBounds(dst.getPhysicalWidth(), dst.getPhysicalHeight());
        int dstscan = dst.getScanlineStride();
        int[] dstPixels = dst.getPixelArray();

        int count = lcrstate.getPassKernelSize();
        FloatBuffer weights_buf = lcrstate.getPassWeights();

        PassType type = lcrstate.getPassType();
        if (!src0Transform.isIdentity() ||
                !dstBounds.contains(dstRawBounds.x, dstRawBounds.y)) {
            // RT-27406
            // TODO: Fix the optimized loops to deal with non-zero srcxy0
            // and transforms...
            type = PassType.GENERAL_VECTOR;
        }
        if (type == PassType.HORIZONTAL_CENTERED) {
            float[] weights_arr = new float[count * 2];
            weights_buf.get(weights_arr, 0, count);
            weights_buf.rewind();
            weights_buf.get(weights_arr, count, count);
            filterHV(dstPixels, dstw, dsth, 1, dstscan,
                    srcPixels, srcw, srch, 1, srcscan,
                    weights_arr);
        } else if (type == PassType.VERTICAL_CENTERED) {
            float[] weights_arr = new float[count * 2];
            weights_buf.get(weights_arr, 0, count);
            weights_buf.rewind();
            weights_buf.get(weights_arr, count, count);
            filterHV(dstPixels, dsth, dstw, dstscan, 1,
                    srcPixels, srch, srcw, srcscan, 1,
                    weights_arr);
        } else {
            float[] weights_arr = new float[count];
            weights_buf.get(weights_arr, 0, count);

            float[] srcRect = new float[8];
            int nCoords = getTextureCoordinates(0, srcRect,
                    src0Bounds.x, src0Bounds.y,
                    src0NativeBounds.width,
                    src0NativeBounds.height,
                    dstBounds, src0Transform);
            float srcx0 = srcRect[0] * srcw;
            float srcy0 = srcRect[1] * srch;
            float dxcol, dycol, dxrow, dyrow;
            if (nCoords < 8) {
                dxcol = (srcRect[2] - srcRect[0]) * srcw / dstBounds.width;
                dycol = 0f;
                dxrow = 0f;
                dyrow = (srcRect[3] - srcRect[1]) * srch / dstBounds.height;
            } else {
                dxcol = (srcRect[4] - srcRect[0]) * srcw / dstBounds.width;
                dycol = (srcRect[5] - srcRect[1]) * srch / dstBounds.height;
                dxrow = (srcRect[6] - srcRect[0]) * srcw / dstBounds.width;
                dyrow = (srcRect[7] - srcRect[1]) * srch / dstBounds.height;
            }

            float[] offset_arr = lcrstate.getPassVector();
            float deltax = offset_arr[0] * srcw;
            float deltay = offset_arr[1] * srch;
            float offsetx = offset_arr[2] * srcw;
            float offsety = offset_arr[3] * srch;

            filterVector(dstPixels, dstw, dsth, dstscan,
                    srcPixels, srcw, srch, srcscan,
                    weights_arr, count,
                    srcx0, srcy0,
                    offsetx, offsety,
                    deltax, deltay,
                    dxcol, dycol, dxrow, dyrow);
        }

        return new ImageData(getFilterContext(), dst, dstBounds);
    }

    native void
    filterVector(int dstPixels[], int dstw, int dsth, int dstscan,
                 int srcPixels[], int srcw, int srch, int srcscan,
                 float weights[], int count,
                 float srcx0, float srcy0,
                 float offsetx, float offsety,
                 float deltax, float deltay,
                 float dxcol, float dycol, float dxrow, float dyrow);

    /*
     * In the nomenclature of the argument list for this method, "row" refers
     * to the coordinate which increments once for each new stream of single
     * axis data that we are blurring in a single pass.  And "col" refers to
     * the other coordinate that increments along the row.
     * Rows are horizontal in the first pass and vertical in the second pass.
     * Cols are vice versa.
     */
    native void
    filterHV(int dstPixels[], int dstcols, int dstrows, int dcolinc, int drowinc,
             int srcPixels[], int srccols, int srcrows, int scolinc, int srowinc,
             float weights[]);
}
