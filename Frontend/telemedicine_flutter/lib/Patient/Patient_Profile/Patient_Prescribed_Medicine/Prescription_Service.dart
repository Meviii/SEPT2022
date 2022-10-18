import 'dart:convert';

import 'package:http/http.dart' as http;
import 'package:telemedicine_flutter/Model/PrescriptionModel.dart';

class PrescriptionService{

  Future<List<Prescription>?> getPrescription() async{
    var url = "http://localhost:8085/api/v1/prescription/";

    var response = await http.get(Uri.parse(url),
    headers: {
      "Access-Control-Allow-Origin": "*",
      "Accept": "application/json"
    });
    if (response.statusCode == 200){
      var jsonData = json.decode(response.body);
      List<Prescription> prescriptions = [];
      //json.encode(jsonData);
      
    // Iterate through all users, only adding patient user types
      for(int i = 0; i < jsonData.length; i++) {

        
        prescriptions.add(Prescription.fromJson(jsonData[i]));
      
      
      }

      return prescriptions;
    }
    else{

    }

  }
}