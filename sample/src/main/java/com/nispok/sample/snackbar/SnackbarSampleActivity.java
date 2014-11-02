package com.nispok.sample.snackbar;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.enums.SnackbarType;
import com.nispok.snackbar.listeners.ActionClickListener;
import com.nispok.snackbar.listeners.EventListener;

import java.lang.Override;

public class SnackbarSampleActivity extends Activity {

    private static final String TAG = SnackbarSampleActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        Button singleLineButton = (Button) findViewById(R.id.single_line);
        singleLineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.with(SnackbarSampleActivity.this)
                        .text("Single-line snackbar")
                        .show(SnackbarSampleActivity.this);
            }
        });

        Button singleLineWithActionButton = (Button) findViewById(R.id.single_line_with_action);
        singleLineWithActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.with(SnackbarSampleActivity.this)
                        .text("Something has been done")
                        .actionLabel("Undo")
                        .actionListener(new ActionClickListener() {
                            @Override
                            public void onActionClicked() {
                                Log.i(TAG, "Action touched");
                            }
                        })
                        .show(SnackbarSampleActivity.this);
            }
        });

        Button multiLineButton = (Button) findViewById(R.id.multi_line);
        multiLineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.with(SnackbarSampleActivity.this)
                        .type(SnackbarType.MULTI_LINE)
                        .text("This is a multi-line snackbar. Keep in mind that snackbars are " +
                                "meant for VERY short messages")
                        .show(SnackbarSampleActivity.this);
            }
        });

        Button multiLineWithActionButton = (Button) findViewById(R.id.multi_line_with_action);
        multiLineWithActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.with(SnackbarSampleActivity.this)
                        .type(SnackbarType.MULTI_LINE)
                        .text("This is a multi-line snackbar with an action button. Note that " +
                                "multi-line snackbars are 2 lines max")
                        .actionLabel("Action")
                        .actionListener(new ActionClickListener() {
                            @Override
                            public void onActionClicked() {
                                Log.i(TAG, "Action touched");
                            }
                        })
                        .show(SnackbarSampleActivity.this);
            }
        });

        Button noAnimationButton = (Button) findViewById(R.id.no_animation);
        noAnimationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.with(SnackbarSampleActivity.this)
                        .text("No animation :(")
                        .animation(false)
                        .duration(1000l)
                        .show(SnackbarSampleActivity.this);
            }
        });

        Button eventListenerButton = (Button) findViewById(R.id.event_listener);
        eventListenerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.with(SnackbarSampleActivity.this)
                        .text("This will do something on enter/exit")
                        .eventListener(new EventListener() {
                            @Override
                            public void onShow(int height) {
                                Log.i(TAG, "Snackbar will show. Height: " + height);
                            }

                            @Override
                            public void onDismiss(int height) {
                                Log.i(TAG, "Snackbar dismissed. Height: " + height);
                            }
                        })
                        .show(SnackbarSampleActivity.this);
            }
        });

        Button customColorsButton = (Button) findViewById(R.id.custom_colors);
        customColorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.with(SnackbarSampleActivity.this)
                        .text("Shorter message, different colors")
                        .textColor(Color.parseColor("#ff9d9d9c"))
                        .color(Color.parseColor("#ff914300"))
                        .actionLabel("Action")
                        .actionColor(Color.parseColor("#ff5a2900"))
                        .actionListener(new ActionClickListener() {
                            @Override
                            public void onActionClicked() {
                                Log.i(TAG, "Action touched");
                            }
                        })
                        .duration(Snackbar.SnackbarDuration.LENGTH_SHORT)
                        .show(SnackbarSampleActivity.this);
            }
        });

        Button swipeableButton = (Button) findViewById(R.id.swipeable);
        swipeableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.with(SnackbarSampleActivity.this)
                        .text("Swipe me off the screen")
                        .swipeToDismiss(true)
                        .show(SnackbarSampleActivity.this);
            }
        });
    }

}