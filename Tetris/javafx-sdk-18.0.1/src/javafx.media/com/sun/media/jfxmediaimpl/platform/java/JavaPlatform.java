/*
 * Copyright (c) 2010, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.media.jfxmediaimpl.platform.java;

import com.sun.media.jfxmedia.Media;
import com.sun.media.jfxmedia.MediaPlayer;
import com.sun.media.jfxmedia.MetadataParser;
import com.sun.media.jfxmedia.locator.Locator;
import com.sun.media.jfxmediaimpl.MediaUtils;
import com.sun.media.jfxmediaimpl.platform.Platform;

/**
 * Java platform implementation.
 */
public final class JavaPlatform extends Platform {
    private static JavaPlatform globalInstance = null;

    public static synchronized Platform getPlatformInstance() {
        if (null == globalInstance) {
            globalInstance = new JavaPlatform();
        }

        return globalInstance;
    }

    JavaPlatform() {
    }

    @Override
    public boolean loadPlatform() {
        return true;
    }

    // XXX Move MetadataParser.createMetadataParser content here?
    @Override
    public MetadataParser createMetadataParser(Locator source) {
        String contentType = source.getContentType();
        if (contentType.equals(MediaUtils.CONTENT_TYPE_MPA) ||
                contentType.equals(MediaUtils.CONTENT_TYPE_MP3)) {
            return new ID3MetadataParser(source);
        }

        return null;
    }

    @Override
    public Media createMedia(Locator source) {
        return null;
    }

    @Override
    public MediaPlayer createMediaPlayer(Locator source) {
        return null;
    }
}
