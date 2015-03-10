package com.emoji.util;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.emoji.util.library.EmojiClickListener;
import com.emoji.util.library.EmojiEditText;
import com.emoji.util.library.EmojiTextView;
import com.emoji.util.library.EmojiUtil;
import com.emoji.util.library.EmojiView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(R.layout.activity_main);
        final EmojiTextView mEmojiTextView = (EmojiTextView) findViewById(R.id.ett_EmojiTextView);
//        mEmojiTextView.setEmojiText("你好啊[可爱]hh[ok][可爱]");

        final EmojiEditText mEmojiEditText = (EmojiEditText) findViewById(R.id.eet_EmojiEditText);
        EmojiView mEmojiView = (EmojiView) findViewById(R.id.ev_EmojiView);
        mEmojiView.setOnEmojiItemClickListener(new EmojiClickListener() {
            @Override
            public void onClick(CharSequence text) {
                if (mEmojiEditText.getSelectionStart() == mEmojiEditText.length()) {
                    mEmojiEditText.append(text);
                } else {
                    mEmojiEditText.insert(mEmojiEditText.getSelectionStart(), text);
                }
            }
        });

//        mEmojiView.initView(new EmojiClickListener() {
//            @Override
//            public void onClick(CharSequence text) {
//                if (mEmojiEditText.getSelectionStart() == mEmojiEditText.length()) {
//                    mEmojiEditText.append(text);
//                } else {
//                    mEmojiEditText.insert(mEmojiEditText.getSelectionStart(), text);
//                }
//            }
//        });


//        mEmojiView.setOnEmojiItemClickListener();
    }


    public void init() {
        EmojiUtil.emojiId = new int[]{
                R.mipmap.d_zuiyou,
                R.mipmap.d_hehe,
                R.mipmap.d_xixi,
                R.mipmap.d_haha,
                R.mipmap.d_aini,
                R.mipmap.d_wabishi,
                R.mipmap.d_chijing,
                R.mipmap.d_yun,
                R.mipmap.d_lei,
                R.mipmap.d_chanzui,
                R.mipmap.d_zhuakuang,
                R.mipmap.d_heng,
                R.mipmap.d_kelian,
                R.mipmap.d_nu,
                R.mipmap.d_han,
                R.mipmap.d_haixiu,
                R.mipmap.d_shuijiao,
                R.mipmap.d_qian,
                R.mipmap.d_touxiao,
                R.mipmap.d_xiaoku,
                R.mipmap.d_doge,
                R.mipmap.d_miao,
                R.mipmap.d_ku,
                R.mipmap.d_shuai,
                R.mipmap.d_bizui,
                R.mipmap.d_bishi,
                R.mipmap.d_huaxin,
                R.mipmap.d_guzhang,
                R.mipmap.d_beishang,
                R.mipmap.d_sikao,
                R.mipmap.d_shengbing,
                R.mipmap.d_qinqin,
                R.mipmap.d_numa,
                R.mipmap.d_taikaixin,
                R.mipmap.d_landelini,
                R.mipmap.d_youhengheng,
                R.mipmap.d_zuohengheng,
                R.mipmap.d_xu,
                R.mipmap.d_weiqu,
                R.mipmap.d_tu,
                R.mipmap.d_kelian,
                R.mipmap.d_dahaqi,
                R.mipmap.d_jiyan,
                R.mipmap.d_shiwang,
                R.mipmap.d_ding,
                R.mipmap.d_yiwen,
                R.mipmap.d_kun,
                R.mipmap.d_ganmao,
                R.mipmap.d_baibai,
                R.mipmap.d_heixian,
                R.mipmap.d_yinxian,
                R.mipmap.d_dalian,
                R.mipmap.d_shayan,
                R.mipmap.f_hufen,
                R.mipmap.l_xin,
                R.mipmap.l_shangxin,
                R.mipmap.d_zhutou,
                R.mipmap.d_xiongmao,
                R.mipmap.d_tuzi,
                R.mipmap.h_woshou,
                R.mipmap.h_zuoyi,
                R.mipmap.h_zan,
                R.mipmap.h_ye,
                R.mipmap.h_good,
                R.mipmap.h_ruo,
                R.mipmap.h_buyao,
                R.mipmap.h_ok,
                R.mipmap.h_haha,
                R.mipmap.h_lai,
                R.mipmap.f_v5,
                R.mipmap.w_xianhua,
                R.mipmap.o_zhong,
                R.mipmap.w_fuyun,
                R.mipmap.o_feiji,
                R.mipmap.w_yueliang,
                R.mipmap.w_taiyang,
                R.mipmap.w_weifeng,
                R.mipmap.w_xiayu,
                R.mipmap.f_geili,
                R.mipmap.f_shenma,
                R.mipmap.o_weiguan,
                R.mipmap.o_huatong,
                R.mipmap.d_aoteman,
                R.mipmap.d_shenshou,
                R.mipmap.f_meng,
                R.mipmap.f_jiong,
                R.mipmap.f_zhi,
                R.mipmap.o_liwu,
                R.mipmap.f_xi,
                R.mipmap.o_weibo,
                R.mipmap.o_yinyue,
                R.mipmap.o_lvsidai,
                R.mipmap.o_dangao,
                R.mipmap.o_lazhu,
                R.mipmap.o_ganbei,
                R.mipmap.d_nanhaier,
                R.mipmap.d_nvhaier,
                R.mipmap.d_feizao,
                R.mipmap.o_zhaoxiangji,
                R.mipmap.d_lang,
                R.mipmap.w_shachenbao,
        };
        EmojiUtil.emojiName = new String[]{
                "[最右]",
                "[呵呵]",
                "[嘻嘻]",
                "[哈哈]",
                "[爱你]",
                "[挖鼻屎]",
                "[吃惊]",
                "[晕]",
                "[泪]",
                "[馋嘴]",
                "[抓狂]",
                "[哼]",
                "[可爱]",
                "[怒]",
                "[汗]",
                "[害羞]",
                "[睡觉]",
                "[钱]",
                "[偷笑]",
                "[笑cry]",
                "[doge]",
                "[喵喵]",
                "[酷]",
                "[衰]",
                "[闭嘴]",
                "[鄙视]",
                "[花心]",
                "[鼓掌]",
                "[悲伤]",
                "[思考]",
                "[生病]",
                "[亲亲]",
                "[怒骂]",
                "[太开心]",
                "[懒得理你]",
                "[右哼哼]",
                "[左哼哼]",
                "[嘘]",
                "[委屈]",
                "[吐]",
                "[可怜]",
                "[打哈气]",
                "[挤眼]",
                "[失望]",
                "[顶]",
                "[疑问]",
                "[困]",
                "[感冒]",
                "[拜拜]",
                "[黑线]",
                "[阴险]",
                "[打脸]",
                "[傻眼]",
                "[互粉]",
                "[心]",
                "[伤心]",
                "[猪头]",
                "[熊猫]",
                "[兔子]",
                "[握手]",
                "[作揖]",
                "[赞]",
                "[耶]",
                "[good]",
                "[弱]",
                "[不要]",
                "[ok]",
                "[haha]",
                "[来]",
                "[威武]",
                "[鲜花]",
                "[钟]",
                "[浮云]",
                "[飞机]",
                "[月亮]",
                "[太阳]",
                "[微风]",
                "[下雨]",
                "[给力]",
                "[神马]",
                "[围观]",
                "[话筒]",
                "[奥特曼]",
                "[草泥马]",
                "[萌]",
                "[囧]",
                "[织]",
                "[礼物]",
                "[喜]",
                "[围脖]",
                "[音乐]",
                "[绿丝带]",
                "[蛋糕]",
                "[蜡烛]",
                "[干杯]",
                "[男孩儿]",
                "[女孩儿]",
                "[肥皂]",
                "[照相机]",
                "[浪]",
                "[沙尘暴]",
        };
    }
}
