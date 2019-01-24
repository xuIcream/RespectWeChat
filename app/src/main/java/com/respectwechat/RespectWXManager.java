/*
 * Copyright (C) Copyright (C) 2019 Beijing KuaiRu Technology Ltd. All rights reserved.
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
package com.respectwechat;

import android.app.ActivityThread;
import android.app.Instrumentation;
import android.util.Log;

public class RespectWXManager {

    public static final String TAG = "RespectWXManager";

    private static volatile RespectWXManager sInstance = null;
    private Instrumentation mOriginInstrumentation;

    public static RespectWXManager getInstance() {
        if (sInstance == null) {
            synchronized (RespectWXManager.class) {
                if (sInstance == null) {
                    sInstance = new RespectWXManager();
                }
            }
        }

        return sInstance;
    }

    private RespectWXManager() {
    }

    public void start() {
        if (mOriginInstrumentation == null) {
            try {
                ActivityThread activityThread = ActivityThread.currentActivityThread();
                Instrumentation baseInstrumentation = activityThread.getInstrumentation();
                mOriginInstrumentation = baseInstrumentation;
                RespectWXInstrumentation instrumentation = new RespectWXInstrumentation(baseInstrumentation);
                ReflectionUtil.setFieldValue(activityThread, "mInstrumentation", instrumentation);
                Log.d(TAG, "start hookInstrumentation succeed : " + instrumentation);
            } catch (Exception e) {
                Log.w(TAG, e);
            }
        }
    }

    public void stop() {
        if (mOriginInstrumentation != null) {
            try {
                ActivityThread activityThread = ActivityThread.currentActivityThread();
                ReflectionUtil.setFieldValue(activityThread, "mInstrumentation", mOriginInstrumentation);
                Log.d(TAG, "stop hookInstrumentation succeed : " + mOriginInstrumentation);
            } catch (Exception e) {
                Log.w(TAG, e);
            }
            mOriginInstrumentation = null;
        }
    }



}