/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.glass.ui.ios;

import com.sun.glass.ui.MenuItem;
import com.sun.glass.ui.Pixels;
import com.sun.glass.ui.delegate.MenuDelegate;
import com.sun.glass.ui.delegate.MenuItemDelegate;

/**
 * MenuDelegate implementation stub for iOS.
 * Calling IosMenuDelegate's methods has no effect.
 */
final class IosMenuDelegate implements MenuDelegate, MenuItemDelegate {

    /**
     * @inheritDoc Unsupported on iOS.
     */
    @Override
    public boolean createMenu(String title, boolean enabled) {
        return true;
    }

    /**
     * @inheritDoc Unsupported on iOS.
     */
    @Override
    public boolean createMenuItem(String title, MenuItem.Callback callback, int shortcutKey, int shortcutModifiers, Pixels pixels, boolean enabled, boolean checked) {
        return true;
    }

    /**
     * @inheritDoc Unsupported on iOS.
     */
    @Override
    public boolean setTitle(String title) {
        return true;
    }

    /**
     * @inheritDoc Unsupported on iOS.
     */
    @Override
    public boolean setCallback(MenuItem.Callback callback) {
        return true;
    }

    /**
     * @inheritDoc Unsupported on iOS.
     */
    @Override
    public boolean setShortcut(int shortcutKey, int shortcutModifiers) {
        return true;
    }

    /**
     * @inheritDoc Unsupported on iOS.
     */
    @Override
    public boolean setPixels(Pixels pixels) {
        return true;
    }

    /**
     * @inheritDoc Unsupported on iOS.
     */
    @Override
    public boolean setEnabled(boolean enabled) {
        return true;
    }

    /**
     * @inheritDoc Unsupported on iOS.
     */
    @Override
    public boolean setChecked(boolean checked) {
        return true;
    }

    /**
     * @inheritDoc Unsupported on iOS.
     */
    @Override
    public boolean insert(MenuDelegate menu, int pos) {
        return true;
    }

    /**
     * @inheritDoc Unsupported on iOS.
     */
    @Override
    public boolean insert(MenuItemDelegate item, int pos) {
        return true;
    }

    /**
     * @inheritDoc Unsupported on iOS.
     */
    @Override
    public boolean remove(MenuDelegate menu, int pos) {
        return true;
    }

    /**
     * @inheritDoc Unsupported on iOS.
     */
    @Override
    public boolean remove(MenuItemDelegate item, int pos) {
        return true;
    }
}
