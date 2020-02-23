package com.neo.model;

import java.io.Serializable;
import java.util.List;

public class WeatherResponse implements Serializable {
   private String code;
   private String charge;
   private String remain;
   private String msg;
   private Weather  result;

   public String getCode() {
      return code;
   }

   public void setCode(String code) {
      this.code = code;
   }

   public String getCharge() {
      return charge;
   }

   public void setCharge(String charge) {
      this.charge = charge;
   }

   public String getRemain() {
      return remain;
   }

   public void setRemain(String remain) {
      this.remain = remain;
   }

   public String getMsg() {
      return msg;
   }

   public void setMsg(String msg) {
      this.msg = msg;
   }

   public Weather getResult() {
      return result;
   }

   public void setResult(Weather result) {
      this.result = result;
   }
}
