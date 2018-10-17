package com.pspdfkit.react.events;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.react.helper.JsonUtilities;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PdfViewDataReturnedEvent extends Event<PdfViewDataReturnedEvent> {

    public static final String EVENT_NAME = "pdfViewDataReturned";

    private final int requestId;
    private final WritableMap payload;

    public PdfViewDataReturnedEvent(@IdRes int viewId, int requestId, @NonNull List<Annotation> annotationsToSerialize) {
        super(viewId);
        this.requestId = requestId;
        Map<String, Object> map = new HashMap<>();
        map.put("requestId", requestId);
        try {
            List<Map<String, Object>> annotationsSerialized = new ArrayList<>();
            for (Annotation annotation : annotationsToSerialize) {
                JSONObject instantJson = new JSONObject(annotation.toInstantJson());
                annotationsSerialized.add(JsonUtilities.jsonObjectToMap(instantJson));
            }

            Map<String, Object> annotations = new HashMap<>();
            annotations.put("annotations", annotationsSerialized);
            map.put("result", annotations);
        } catch (JSONException e) {
            map.put("error", e.getMessage());
        }

        payload = Arguments.makeNativeMap(map);
    }

    public PdfViewDataReturnedEvent(@IdRes int viewId, int requestId, @NonNull JSONObject jsonObject) {
        super(viewId);
        this.requestId = requestId;
        Map<String, Object> map = new HashMap<>();
        map.put("requestId", requestId);

        try {
            map.put("result", JsonUtilities.jsonObjectToMap(jsonObject));
        } catch (JSONException e) {
            map.put("error", e.getMessage());
        }

        payload = Arguments.makeNativeMap(map);
    }

    public PdfViewDataReturnedEvent(@IdRes int viewId, int requestId, @NonNull Throwable throwable) {
        super(viewId);
        this.requestId = requestId;
        payload = Arguments.createMap();
        payload.putInt("requestId", requestId);
        payload.putString("error", throwable.getMessage());
    }

    @Override
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override
    public void dispatch(RCTEventEmitter rctEventEmitter) {
        rctEventEmitter.receiveEvent(getViewTag(), getEventName(), payload);
    }

    @Override
    public short getCoalescingKey() {
        return (short) requestId;
    }
}
