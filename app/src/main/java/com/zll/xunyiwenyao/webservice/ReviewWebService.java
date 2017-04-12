package com.zll.xunyiwenyao.webservice;

import com.zll.xunyiwenyao.dbitem.Review;
import com.zll.xunyiwenyao.dbitem.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kejund on 17/3/30.
 */

public class ReviewWebService {
    private static List<Review> reviewlist;

    static{
        reviewlist = new ArrayList<Review>();
        Review review = null;

        review = new Review("药物过期评价","阿司匹林","过期","2015-2-2", Utils.LOGIN_DOCTOR,"无");
        reviewlist.add(review);

        review = new Review("药物无效评价","Drug ","经多个用户反映，该药物无效","2016-9-22", Utils.LOGIN_DOCTOR,"无");
        reviewlist.add(review);
    }

    public static void addReview(Review item){
        reviewlist.add(item);
    }

    public static List<Review> getAllReview(){
        return reviewlist;
    }

}
