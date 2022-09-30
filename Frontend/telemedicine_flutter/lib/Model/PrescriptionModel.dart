import 'dart:convert';
import 'package:intl/intl.dart';

import 'MedicineModel.dart';

String prescriptionToJson(Prescription data) => json.encode(data.toJson());

class Prescription {

  String id;
  List<Medicine> medicines;
  String duration;
  String description;
  DateTime date;
  String doctorId;
  String patientId;

  Prescription(this.id, this.medicines, this.duration, this.description, this.date,
  this.doctorId, this.patientId);

  Prescription.fromJson(Map<String, dynamic> json) :
    id = json["id"],
    medicines = medicineListFromJson(json["medicines"]),
    duration = json["duration"],
    description = json["description"],
    date = DateFormat('yy-MM-dd').parse(json["date"]),
    doctorId = json["doctorId"],
    patientId = json["patientId"]
  ;

  Map<String, dynamic> toJson() => {
    "id": id,
    "medicines": jsonEncode(medicines),
    "duration": duration,
    "description": description,
    "date": date.toString(),
    "doctorId": doctorId,
    "patientId": patientId
  };

  String get getId => id;
  List<Medicine> get getMedicines => medicines;
  String get getDuration => duration;
  String get getDescription => description;
  DateTime get getDate => date;
  String get getDoctorId => doctorId;
  String get getPatientId => patientId;
}

// Method to convert a JSON medicine list to a list object
List<Medicine> medicineListFromJson(Map<String, dynamic> json) {
  List<Medicine> medicines = [];

  for(int i = 0; i < json.length; i++) {
    medicines.add(Medicine.fromJson(json[i]));
  }

  return medicines;
}