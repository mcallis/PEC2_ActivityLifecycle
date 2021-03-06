/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.uoc.pec2.android.activitylifecycle;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Example Activity to demonstrate the lifecycle callback methods.
 */
public class ActivityB extends AppCompatActivity {
    private final String TAG = ActivityB.this.getClass().getSimpleName();

    private Button mButtonActivityA;
    private Button mButtonActivityC;
    private Button mButtonFinishActivityB;
    private Button mButtonStartDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Log.d(TAG, "onCreate");

        // Set views
        mButtonActivityA = (Button) findViewById(R.id.btn_start_a);
        mButtonActivityC = (Button) findViewById(R.id.btn_start_c);
        mButtonFinishActivityB = (Button) findViewById(R.id.btn_finish_b);
        mButtonStartDialog = (Button) findViewById(R.id.btn_start_dialog);

        // Set Listeners
        mButtonActivityA.setOnClickListener(startActivityAListener);
        mButtonActivityC.setOnClickListener(startActivityCListener);
        mButtonFinishActivityB.setOnClickListener(finishActivityBListener);
        mButtonStartDialog.setOnClickListener(startDialogListener);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    public void showDialog() {
        Log.d(TAG, "showDialog");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Add the buttons
        builder.setPositiveButton(R.string.dialog_ok_button, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
                Log.d(TAG, "dismiss");
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(R.string.dialog_cancel_button, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
                Log.d(TAG, "dismiss");
                dialog.dismiss();
            }
        });
        builder.setTitle(R.string.dialog_title);
        builder.setMessage(R.string.dialog_message);
        // Create the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    public void startActivityA() {
        Log.d(TAG, "startActivityA");
        Intent intent = new Intent(ActivityB.this, ActivityA.class);
        startActivity(intent);
    }

    public void startActivityC() {
        Log.d(TAG, "startActivityC");
        Intent intent = new Intent(ActivityB.this, ActivityC.class);
        startActivity(intent);
    }

    public void finishActivityB() {
        Log.d(TAG, "finishActivityB");
        ActivityB.this.finish();
    }

    // Listeners
    private View.OnClickListener startActivityAListener = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            startActivityA();
        }
    };

    private View.OnClickListener startActivityCListener = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            startActivityC();
        }
    };

    private View.OnClickListener finishActivityBListener = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            finishActivityB();
        }
    };

    private View.OnClickListener startDialogListener = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            showDialog();
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d(TAG, "onBackPressed");
    }
}
