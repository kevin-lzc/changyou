package com.example.happytravel.bean;

import java.util.List;

public class ImageBean {

    /**
     * code : 200
     * message : 成功!
     * result : [{"id":218,"time":"2018-09-18 17:52:40","img":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-23-16906361_1846962082218545_7116720067412230144_n.jpg"},{"id":527,"time":"2018-09-18 17:52:42","img":"http://ww4.sinaimg.cn/large/7a8aed7bjw1ey2lc2h2ckj20o20gxacp.jpg"},{"id":423,"time":"2018-09-18 17:52:42","img":"http://ww4.sinaimg.cn/large/7a8aed7bjw1f32d0cumhkj20ey0mitbx.jpg"},{"id":629,"time":"2018-09-18 17:52:43","img":"http://ww3.sinaimg.cn/large/7a8aed7bgw1et95oadpnjj20qo0hs0vk.jpg"},{"id":600,"time":"2018-09-18 17:52:43","img":"http://ww3.sinaimg.cn/large/610dc034gw1eujhf1599jj20dt0kuwhi.jpg"},{"id":148,"time":"2018-09-18 17:52:40","img":"https://ws1.sinaimg.cn/large/610dc034ly1fgj7jho031j20u011itci.jpg"},{"id":87,"time":"2018-09-18 17:52:39","img":"http://7xi8d6.com1.z0.glb.clouddn.com/20171113084220_LuJgqv_sakura.gun_13_11_2017_8_42_12_311.jpeg"},{"id":641,"time":"2018-09-18 17:52:43","img":"http://ww1.sinaimg.cn/large/7a8aed7bgw1eswem6zx1mj20qo0hrwgs.jpg"},{"id":32,"time":"2018-09-18 17:52:39","img":"http://ww1.sinaimg.cn/large/0065oQSqly1fs8u1joq6fj30j60orwin.jpg"},{"id":183,"time":"2018-09-18 17:52:40","img":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-16-17934400_1738549946443321_2924146161843437568_n.jpg"},{"id":573,"time":"2018-09-18 17:52:42","img":"http://ww2.sinaimg.cn/large/610dc034gw1evtqr0q1r0j20fa0mx0vv.jpg"},{"id":304,"time":"2018-09-18 17:52:41","img":"http://ww3.sinaimg.cn/large/610dc034jw1f8qd9a4fx7j20u011hq78.jpg"},{"id":125,"time":"2018-09-18 17:52:39","img":"https://ws1.sinaimg.cn/large/610dc034ly1fibksd2mbmj20u011iacx.jpg"},{"id":438,"time":"2018-09-18 17:52:42","img":"http://ww3.sinaimg.cn/large/7a8aed7bjw1f2cfxa9joaj20f00fzwg2.jpg"},{"id":396,"time":"2018-09-18 17:52:41","img":"http://ww1.sinaimg.cn/large/610dc034jw1f4d4iji38kj20sg0izdl1.jpg"},{"id":615,"time":"2018-09-18 17:52:43","img":"http://ww2.sinaimg.cn/large/7a8aed7bgw1etwa7ayf35j20j60csmzb.jpg"},{"id":571,"time":"2018-09-18 17:52:42","img":"http://ww3.sinaimg.cn/large/7a8aed7bgw1evvxu1plowj20qo0hsgoz.jpg"},{"id":79,"time":"2018-09-18 17:52:39","img":"http://7xi8d6.com1.z0.glb.clouddn.com/20171206084331_wylXWG_misafighting_6_12_2017_8_43_16_390.jpeg"},{"id":153,"time":"2018-09-18 17:52:40","img":"https://ws1.sinaimg.cn/large/610dc034ly1fgbbp94y9zj20u011idkf.jpg"},{"id":664,"time":"2018-11-20 04:00:01","img":"https://ws1.sinaimg.cn/large/0065oQSqgy1fxd7vcz86nj30qo0ybqc1.jpg"}]
     */

    private int code;
    private String message;
    private List<ResultBean> result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ImageBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }

    public static class ResultBean {
        /**
         * id : 218
         * time : 2018-09-18 17:52:40
         * img : http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-23-16906361_1846962082218545_7116720067412230144_n.jpg
         */

        private int id;
        private String time;
        private String img;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        @Override
        public String toString() {
            return "ResultBean{" +
                    "id=" + id +
                    ", time='" + time + '\'' +
                    ", img='" + img + '\'' +
                    '}';
        }
    }
}


