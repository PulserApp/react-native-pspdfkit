package com.pspdfkit.views.toolbar;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.pspdfkit.react.R;
import com.pspdfkit.ui.toolbar.grouping.presets.AnnotationCreationToolbarItemPresets;
import com.pspdfkit.ui.toolbar.grouping.presets.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class PulserToolbarItemPresets {
    public static final List<MenuItem> FOUR_ITEMS_GROUPING = new ArrayList(5);
    public static final List<MenuItem> FIVE_ITEMS_GROUPING = new ArrayList(6);
    public static final List<MenuItem> SIX_ITEMS_GROUPING = new ArrayList(7);
    public static final List<MenuItem> EIGHT_ITEMS_GROUPING = new ArrayList(9);
    public static final List<MenuItem> TEN_ITEMS_GROUPING = new ArrayList(11);
    public static final List<MenuItem> ALL_ITEMS_GROUPING = new ArrayList(21);

    public PulserToolbarItemPresets() {
    }

    @Nullable
    private static void insertBefore(@NonNull List<MenuItem> items, @NonNull MenuItem item, @IdRes int beforeItemId) {
        ListIterator iterator = items.listIterator();

        while (iterator.hasNext()) {
            int index = iterator.nextIndex();

            if (((MenuItem) iterator.next()).id == beforeItemId) {
                items.add(index, item);

                break;
            }
        }
    }

    static {
        FOUR_ITEMS_GROUPING.addAll(AnnotationCreationToolbarItemPresets.FOUR_ITEMS_GROUPING);
        FIVE_ITEMS_GROUPING.addAll(AnnotationCreationToolbarItemPresets.FIVE_ITEMS_GROUPING);
        SIX_ITEMS_GROUPING.addAll(AnnotationCreationToolbarItemPresets.SIX_ITEMS_GROUPING);
        EIGHT_ITEMS_GROUPING.addAll(AnnotationCreationToolbarItemPresets.EIGHT_ITEMS_GROUPING);
        TEN_ITEMS_GROUPING.addAll(AnnotationCreationToolbarItemPresets.TEN_ITEMS_GROUPING);
        ALL_ITEMS_GROUPING.addAll(AnnotationCreationToolbarItemPresets.ALL_ITEMS_GROUPING);

        int pinIssueItemId = R.id.pspdf__annotation_creation_toolbar_item_pin_pulser_issue;
        int insertBeforeItemId = R.id.pspdf__annotation_creation_toolbar_item_picker;

        insertBefore(FOUR_ITEMS_GROUPING, new MenuItem(pinIssueItemId), insertBeforeItemId);
        insertBefore(FIVE_ITEMS_GROUPING, new MenuItem(pinIssueItemId), insertBeforeItemId);
        insertBefore(SIX_ITEMS_GROUPING, new MenuItem(pinIssueItemId), insertBeforeItemId);
        insertBefore(EIGHT_ITEMS_GROUPING, new MenuItem(pinIssueItemId), insertBeforeItemId);
        insertBefore(TEN_ITEMS_GROUPING, new MenuItem(pinIssueItemId), insertBeforeItemId);
        insertBefore(ALL_ITEMS_GROUPING, new MenuItem(pinIssueItemId), insertBeforeItemId);
    }
}
