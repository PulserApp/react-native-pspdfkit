package com.pspdfkit.views.toolbar;

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;

import com.pspdfkit.ui.toolbar.ContextualToolbar;
import com.pspdfkit.ui.toolbar.grouping.presets.MenuItem;
import com.pspdfkit.ui.toolbar.grouping.presets.AnnotationCreationToolbarGroupingRule;

import java.util.List;

public class PulserToolbarGroupingRule extends AnnotationCreationToolbarGroupingRule {
    public PulserToolbarGroupingRule(@NonNull Context context) {
        super(context);
    }

    @Override
    public List<MenuItem> getGroupPreset(@IntRange(from = ContextualToolbar.MIN_TOOLBAR_CAPACITY) int capacity, int itemsCount) {
        List items;

        if (capacity == ContextualToolbar.MIN_TOOLBAR_CAPACITY) {
            items = PulserToolbarItemPresets.FOUR_ITEMS_GROUPING;
        } else if (capacity == 5) {
            items = PulserToolbarItemPresets.FIVE_ITEMS_GROUPING;
        } else if (capacity >= 6 && capacity < 8) {
            items = PulserToolbarItemPresets.SIX_ITEMS_GROUPING;
        } else if (capacity >= 8 && capacity < 10) {
            items = PulserToolbarItemPresets.EIGHT_ITEMS_GROUPING;
        } else if (capacity >= 10 && capacity < itemsCount) {
            items = PulserToolbarItemPresets.TEN_ITEMS_GROUPING;
        } else {
            items = PulserToolbarItemPresets.ALL_ITEMS_GROUPING;
        }

        return items;
    }
}