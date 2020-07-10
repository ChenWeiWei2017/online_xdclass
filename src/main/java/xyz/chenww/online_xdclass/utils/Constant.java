package xyz.chenww.online_xdclass.utils;

/**
 * 功能描述：常量类
 *
 * @author chenweiwei
 * @since 2020/7/10
 */
public class Constant {

    public enum PayState {
        NOT_PAY(0, "未支付"),
        HAS_PAY(1, "已支付")
        ;

        private Integer value;

        private String name;

        PayState(Integer value, String name) {
            this.value = value;
            this.name = name;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
