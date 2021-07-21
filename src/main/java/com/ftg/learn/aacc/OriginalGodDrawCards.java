package com.ftg.learn.aacc;

import java.util.Random;

public class OriginalGodDrawCards {

    public int drawCardDegree = 1;
    public int degree = 1;

    //稀有度
    String rarity;

    //武器
    String weapon;

    //武器类型
    String weaponTypes;

    //角色
    String role;

    //元素类别
    String roleElementType;

    //性别
    String roleGender;

    //所属地区
    String roleArea;

    //卡池
    String cardSea;

    public int drawCard() {
        String[] ssrCardSea = {"胡桃", "魈", "甘雨", "阿贝多", "刻晴", "钟离", "七七", "达达利亚", "迪卢克",
                "可莉", "温迪", "莫娜", "琴", "风鹰剑", "斫峰之刃", "天空之刃", "磐岩结绿", "天空之傲", "无工之剑",
                "狼的末路", "天空之翼", "终末嗟叹之诗", "天空之卷", "尘世之锁", "四风原典", "护摩之杖", "和璞鸢", "天空之脊", "贯虹之槊"};

        Random random = new Random();

        System.out.println("开始十连抽卡！卡池单次ssr概率为0.6%,卡池90发保底。");


        //cnt用于计数
        for (int i = 1, cnt = 0; i < 11; i++) {

            //用于%0.6概率随机
            int ssrRandom = random.nextInt(27888);


            //统计抽卡次数,保底或者出货后更新
            drawCardDegree++;

            System.out.println("距离保底还差" + (92 - drawCardDegree) + "次抽卡");

            if (ssrRandom % 167 == 0 || drawCardDegree % 90 == 0) {

                //用于ssr池随机
                int cardSeaRandom = random.nextInt(ssrCardSea.length);

                //统计该次十连抽中ssr的次数
                cnt++;

                //判断抽中的ssr类型
                if (drawCardDegree % 90 == 0 && cardSeaRandom < 13) {
                    System.out.println("恭喜你在该次十连中的第" + i + "发获取到五星保底角色 [ " + ssrCardSea[cardSeaRandom] + " ]");
                    drawCardDegree = 1;
                    degree++;
                } else if (drawCardDegree % 90 == 0 && cardSeaRandom >= 13) {
                    System.out.println("恭喜你在该次十连中的第" + i + "发获取到五星保底武器 [ " + ssrCardSea[cardSeaRandom] + " ]");
                    drawCardDegree = 1;
                    degree++;
                } else if (ssrRandom % 167 == 0 && cardSeaRandom < 13) {
                    System.out.println("恭喜你在该次十连中的第" + i + "发抽到了五星角色 [ " + ssrCardSea[cardSeaRandom] + " ]");
                    drawCardDegree = 1;
                    degree++;
                } else {
                    System.out.println("恭喜你在该次十连中的第" + i + "发抽到了五星武器 [ " + ssrCardSea[cardSeaRandom] + " ]");
                    drawCardDegree = 1;
                    degree++;
                }

            } else if (i == 10 && cnt == 0 && drawCardDegree % 90 != 0) {
                System.out.println("抱歉！您在该次十连中未抽中ssr");
            } else if (i == 10 && cnt != 0) {
                System.out.println("您在该次十连中获取的ssr总数为: " + cnt);
            }
        }

        //返回抽中的ssr数量累计
        return degree;
    }
}