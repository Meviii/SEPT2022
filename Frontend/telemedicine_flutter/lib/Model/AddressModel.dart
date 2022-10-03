import 'dart:convert';

String addressToJson(Address? data) {
  
  if(data != null) {
    return json.encode(data.toJson());

  } else {
    return "null";
  }
} 

class Address {

  int? postCode;
  String? city;
  String? country;
  String? state;
  String? streetName;
  int? streetNo;

  Address(this.streetNo, this.streetName, this.city, this.state, this.postCode, this.country);

  Address.fromJson(Map<String, dynamic> json) :
    streetNo = json["streetNo"],
    streetName = json["streetName"],
    city = json["city"],
    state = json["state"],
    postCode = json["postCode"],
    country = json["country"]
  ;

  Map<String, dynamic> toJson() => {
    "streetNo": streetNo,
    "streetName": streetName,
    "city": city,
    "state": state,
    "postCode": postCode,
    "country": country,
  };

  String get getPostcode {
    
    if(postCode == null) {
      return "";
    }

    return postCode.toString();
  }

  String? get getCity {
    
    if(city == null) {
      return "";
    }

    return city;
  }

  String? get getCountry {

    if(country == null) {
      return "";
    }

    return country;
  }
  
  String? get getState {

    if(state == null) {
      return "";
    }

    return state;
  }

  String? get getStreetName {

    if(streetName == null) {
      return "";
    }

    return streetName;
  }

  String get getStreetNo {
    
    if(streetNo == null) {
      return "";
    }

    return streetNo.toString();
  }
}