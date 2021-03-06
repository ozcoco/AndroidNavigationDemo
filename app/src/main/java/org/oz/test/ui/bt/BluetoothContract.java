package org.oz.test.ui.bt;

import org.oz.test.base.contract.IModel;
import org.oz.test.base.contract.IView;

public class BluetoothContract {

    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {

        default void pickPrinter() {
        }

        default void print() {
        }

    }

    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,即是否使用缓存
    interface Model extends IModel {


    }

}
