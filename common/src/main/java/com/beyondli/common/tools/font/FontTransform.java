package com.beyondli.common.tools.font;

import com.luhuiguo.chinese.ChineseUtils;

/**
 * @author create by JiShaochen
 * @date 2017/12/12 下午11:05
 * @desc 文字繁简体转换
 */
public final class FontTransform {

    private FontTransform() { }

    /**
     * 繁体字转换为简体字
     *
     * @param words
     * @return 简体
     */
    public static String traditionalToSimplified(String words) {
        String resultWords = ChineseUtils.toSimplified(words);
        return resultWords;
    }

    /**
     * 简体字转换为繁体字
     *
     * @param words
     * @return 繁体
     */
    public static String simplifiedToTraditional(String words){
        String resultWords = ChineseUtils.toTraditional(words);
        return resultWords;
    }

}
