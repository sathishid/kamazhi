package com.sathishbabur.kamazhi_accounting.model;

/**
 * Created by sathishbabur on 11/8/2017.
 */

public class BookTypeMaster {
        private int typeId;
        private String name;
        private String desc;

        public BookTypeMaster(int typeId, String name, String desc) {
            this.typeId = typeId;
            this.name = name;
            this.desc = desc;
        }

        public int getTypeId() {
            return typeId;
        }

        public void setTypeId(int typeId) {
            this.typeId = typeId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
}
