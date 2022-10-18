import 'dart:convert';
import 'package:intl/intl.dart';

String appointmentToJson(Appointment data) => json.encode(data.toJson());

class Appointment {

  String id;
  String patientId;
  String doctorId;
  String paymentAmount;
  DateTime start;
  DateTime end;
  
  Appointment(this.id, this.patientId, this.doctorId, this.paymentAmount, 
  this.start, this.end);

  Appointment.fromJson(Map<String, dynamic> json) :
    id = json["id"],
    patientId = json["patientId"],
    doctorId = json["doctorId"],
    paymentAmount = json["paymentAmount"],
    start = DateFormat('yy-MM-dd hh:MM:ss').parse(json["start"]),
    end = DateFormat('yy-MM-dd hh:MM:ss').parse(json["end"])
  ;

  Map<String, dynamic> toJson() => {
    "id": id,
    "patientId": patientId,
    "doctorId": doctorId,
    "paymentAmount": paymentAmount,
    "start": start.toString(),
    "end": end.toString()
  };

  String get getId => id;
  String get getPatientId => patientId;
  String get getDoctorId => doctorId;
  String get getPaymentAmount => paymentAmount;
  DateTime get getStart => start;
  DateTime get getEnd => end;
}