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

import android.app.Activity;
import android.app.Fragment;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class RespectWXInstrumentation extends Instrumentation {
    public static final String TAG = "RespectWX";

    protected Instrumentation mBase;
    protected final ArrayList<WeakReference<Activity>> mActivities = new ArrayList<>();

    public RespectWXInstrumentation(Instrumentation base) {
        this.mBase = base;
        Log.v(TAG," new RespectWXInstrumentation");
    }

    public ActivityResult execStartActivity(Context who, IBinder contextThread, IBinder token, Activity target, Intent intent, int requestCode) {
        Log.v(TAG," start activity..."+target);
        who = hookContext(who);
        return mBase.execStartActivity(who, contextThread, token, target, intent, requestCode);
    }

    public ActivityResult execStartActivity(Context who, IBinder contextThread, IBinder token, Activity target, Intent intent, int requestCode, Bundle options) {
        Log.v(TAG," start activity..."+target);
        who = hookContext(who);
        return mBase.execStartActivity(who, contextThread, token, target, intent, requestCode, options);
    }

    public ActivityResult execStartActivity(Context who, IBinder contextThread, IBinder token, Fragment target, Intent intent, int requestCode, Bundle options) {
        Log.v(TAG," start activity..."+target);
        who = hookContext(who);
        return mBase.execStartActivity(who, contextThread, token, target, intent, requestCode, options);
    }

    public ActivityResult execStartActivity(Context who, IBinder contextThread, IBinder token, String target, Intent intent, int requestCode, Bundle options) {
        Log.v(TAG," start activity..."+target);
        who = hookContext(who);
        return mBase.execStartActivity(who, contextThread, token, target, intent, requestCode, options);
    }

    protected Context hookContext(Context who) {
        return new RespectWXContext(who);
    }
}
