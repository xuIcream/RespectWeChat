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

import android.content.Context;
import android.content.ContextWrapper;

class RespectWXContext extends ContextWrapper {

    public RespectWXContext(Context base) {
        super(base);
    }

    @Override
    public String getPackageName() {
        android.util.Log.v("fuckwx","RespectWXContext getPackageName");
        return "com.fuckwx";
    }

    public String getBasePackageName() {
        android.util.Log.v("fuckwx"," RespectWXContext getBasePackageName");
        return "com.fuckwx";
    }


}
