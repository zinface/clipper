package com.example.clipper;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class ClipboardReceiver extends BroadcastReceiver {
    private static String TAG = "ClipboardReceiver";

    public static String ACTION_SET = "clipper.set";
    public static String ACTION_GET = "clipper.get";
    public static String ACTION_SET_SHORT = "set";
    public static String ACTION_GET_SHORT = "get";
    public static String EXTRA_TEXT = "text";

    public static boolean isActionGet(final String action) {
        return ACTION_GET.equals(action) || ACTION_GET_SHORT.equals(action);
    }

    public static boolean isActionSet(final String action) {
        return ACTION_SET.equals(action) || ACTION_SET_SHORT.equals(action);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive ---- yes");
//        ClipboardManager cb = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
//        if (isActionSet(intent.getAction())) {
//            Log.d(TAG, "Setting text into clipboard");
//            String text = intent.getStringExtra(EXTRA_TEXT);
//            if (text != null) {
//                cb.setText(text);
//                setResultCode(Activity.RESULT_OK);
//                setResultData("Text is copied into clipboard.");
//            } else {
//                setResultCode(Activity.RESULT_CANCELED);
//                setResultData("No text is provided. Use -e text \"text to be pasted\"");
//            }
//        } else if (isActionGet(intent.getAction())) {
//            Log.d(TAG, "Getting text from clipboard");
//            CharSequence clip = cb.getText();
//            if (clip != null) {
//                Log.d(TAG, String.format("Clipboard text: %s", clip));
//                setResultCode(Activity.RESULT_OK);
//                setResultData(clip.toString());
//            } else {
//                setResultCode(Activity.RESULT_CANCELED);
//                setResultData("");
//            }
//        }
        ClipboardManager cb = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        if (isActionSet(intent.getAction())) {
            Log.d(TAG, "Setting text into clipboard");
            CharSequence text = intent.getCharSequenceExtra(EXTRA_TEXT);
            if (text != null) {
                Toast.makeText(context, "有新的可粘贴信息~",Toast.LENGTH_SHORT).show();
                cb.setPrimaryClip(ClipData.newPlainText("clipper", text));
                setResultCode(Activity.RESULT_OK);
                setResultData("Text is copied into clipboard");
            } else {
                setResultCode(Activity.RESULT_CANCELED);
                setResultData("No text is provided. Use -e text \" to be pasted!\"");
            }
        } else if (isActionGet(intent.getAction())) {
            Log.d(TAG, "Getting text from clipboard");
            ClipData clipData = cb.getPrimaryClip();
            if (clipData != null) {
                setResultCode(Activity.RESULT_OK);
                setResultData(clipData.toString());
            } else {
                setResultCode(Activity.RESULT_CANCELED);
                setResultData("");
            }
        }
    }
}
