/**
 *
 */
package com.sohuvideo.ui_plugin.model;

import com.sohuvideo.ui_plugin.control.V4APIResponseCommon;

/**
 * @author kimwang
 */
public class UidData extends V4APIResponseCommon {

    private Uid data;

    public Uid getData() {
        return data;
    }

    public void setData(Uid data) {
        this.data = data;
    }

}
