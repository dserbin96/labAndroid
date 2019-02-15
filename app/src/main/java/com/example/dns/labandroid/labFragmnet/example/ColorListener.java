package com.example.dns.labandroid.labFragmnet.example;

import android.support.annotation.ColorRes;

/*прослушиватель который будет реагировать на изменение цвета*/
public interface ColorListener {
    //метод реализуемый для передачи цвета
    void color(@ColorRes int color);
}
