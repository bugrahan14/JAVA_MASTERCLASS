package com.generics.wildcards;

import java.util.List;

/**
 * Collections.copy benzeri: PECS uygulaması.
 * dest consumer (yazıyoruz) -> ? super T
 * src producer (okuyoruz) -> ? extends T
 */
public final class CopyLikeUtility {

    private CopyLikeUtility() {
    }

    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        if (dest == null || src == null) {
            return;
        }
        dest.clear();
        dest.addAll(src);
    }
}
