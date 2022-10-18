import 'package:flutter/material.dart';
import '../HelperFunctions.dart';

//Page for the account creation button
class AccountCreation extends StatefulWidget {
  const AccountCreation({Key? key}) : super(key: key);

  @override
  State<AccountCreation> createState() => _AccountCreationState();
}

class _AccountCreationState extends State<AccountCreation> {
  TextEditingController textEditingController = TextEditingController();
  @override
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          backgroundColor: Colors.grey,
          title: const Text(
            'Account Creation',
            style: TextStyle(color: Colors.black),
          ),
          centerTitle: true,
          actions: [
            IconButton(
                icon: const Icon(Icons.notifications),
                color: Colors.black,
                onPressed: () {}),
            IconButton(
                icon: const Icon(Icons.question_mark_outlined),
                color: Colors.black,
                onPressed: () {}),
          ],
        ),
        //All the fields in order to create the user.
        body: Padding(
          padding: const EdgeInsets.all(15),
          child: Form(
            child: ListView(children: <Widget>[
              const Padding(
                padding: EdgeInsets.all(15),
                child: TextField(
                  decoration: InputDecoration(
                    border: OutlineInputBorder(),
                    labelText: 'First Name',
                    hintText: 'Enter First Name',
                  ),
                ),
              ),
              const Padding(
                padding: EdgeInsets.all(15),
                child: TextField(
                  decoration: InputDecoration(
                    border: OutlineInputBorder(),
                    labelText: 'Last Name',
                    hintText: 'Enter Last Name',
                  ),
                ),
              ),
              const Padding(
                padding: EdgeInsets.all(15),
                child: TextField(
                  decoration: InputDecoration(
                    border: OutlineInputBorder(),
                    labelText: 'Email',
                    hintText: 'Enter Email',
                  ),
                ),
              ),
              const Padding(
                padding: EdgeInsets.all(15),
                child: TextField(
                  decoration: InputDecoration(
                    border: OutlineInputBorder(),
                    labelText: 'Phone Number',
                    hintText: 'Enter Phone Number',
                  ),
                ),
              ),
              const Padding(
                padding: EdgeInsets.all(15),
                child: TextField(
                  obscureText: true,
                  decoration: InputDecoration(
                    border: OutlineInputBorder(),
                    labelText: 'Password',
                    hintText: 'Enter Password',
                  ),
                ),
              ),
              const Padding(
                padding: EdgeInsets.all(15),
                child: TextField(
                  obscureText: true,
                  decoration: InputDecoration(
                    border: OutlineInputBorder(),
                    labelText: 'Confirm Password',
                    hintText: 'Re-enter Password',
                  ),
                ),
              ),
              const Padding(
                padding: EdgeInsets.all(15),
                child: TextField(
                  obscureText: true,
                  decoration: InputDecoration(
                    border: OutlineInputBorder(),
                    labelText: 'D.O.B',
                    hintText: 'DD/MM/YY',
                  ),
                ),
              ),
              const Padding(
                  padding: EdgeInsets.all(15), child: GenderDropdownItem()),
              const Padding(
                padding: EdgeInsets.all(15),
                child: TextField(
                  obscureText: true,
                  decoration: InputDecoration(
                    border: OutlineInputBorder(),
                    labelText: 'Weight',
                    hintText: 'Enter weight in kg',
                  ),
                ),
              ),
              const Padding(
                padding: EdgeInsets.all(15),
                child: TextField(
                  obscureText: true,
                  decoration: InputDecoration(
                    border: OutlineInputBorder(),
                    labelText: 'Address',
                    hintText: 'Enter Address',
                  ),
                ),
              ),
              const Padding(
                  padding: EdgeInsets.all(15), child: UserDropdownItem()),
              ElevatedButton(
                onPressed: () {},
                child: const Text('Submit'),
              )
            ]),
          ),
        ),
        bottomNavigationBar: BottomNavigationBar(
          type: BottomNavigationBarType.fixed,
          items: const [
            BottomNavigationBarItem(
              icon: Icon(
                Icons.home,
                color: Colors.black,
              ),
              label: 'Home',
            ),
            BottomNavigationBarItem(
              icon: Icon(
                Icons.person,
                color: Colors.black,
              ),
              label: 'Profile',
            ),
            BottomNavigationBarItem(
              icon: Icon(
                Icons.chat,
                color: Colors.black,
              ),
              label: 'Chat',
            ),
            BottomNavigationBarItem(
              icon: Icon(
                Icons.more,
                color: Colors.black,
              ),
              label: 'More',
            ),
          ],
        ));
  }
}

//List for the dropdown options in the AccountCreation page. This dropdownlist
//is for the gender selection
List<DropdownMenuItem<String>> get getGenderDropdownItems {
  List<DropdownMenuItem<String>> genderItems = [
    const DropdownMenuItem(value: "Male", child: Text("Male")),
    const DropdownMenuItem(value: "Female", child: Text("Female")),
    const DropdownMenuItem(value: "Other", child: Text("Other")),
  ];
  return genderItems;
}

class GenderDropdownItem extends StatefulWidget {
  const GenderDropdownItem({Key? key}) : super(key: key);

  @override
  State<GenderDropdownItem> createState() => _GenderDropdownItemState();
}

class _GenderDropdownItemState extends State<GenderDropdownItem> {
  String selectedValue = "Male";
  @override
  Widget build(BuildContext context) {
    return DropdownButton(
        value: selectedValue,
        onChanged: (String? newValue) {
          setState(() {
            selectedValue = newValue!;
          });
        },
        items: getGenderDropdownItems);
  }
}

//List for the dropdown options in the AccountCreation page. This dropdownlist
//is for the User type selection
List<DropdownMenuItem<String>> get getRoleDropdownItems {
  List<DropdownMenuItem<String>> userItems = [
    const DropdownMenuItem(value: "Admin", child: Text("Admin")),
    const DropdownMenuItem(value: "Doctor", child: Text("Doctor")),
    const DropdownMenuItem(value: "Patient", child: Text("Patient")),
  ];
  return userItems;
}

class UserDropdownItem extends StatefulWidget {
  const UserDropdownItem({Key? key}) : super(key: key);
  @override
  State<UserDropdownItem> createState() => _UserDropdownItemState();
}

class _UserDropdownItemState extends State<UserDropdownItem> {
  String selectedValue = "Admin";
  @override
  Widget build(BuildContext context) {
    return DropdownButton(
        value: selectedValue,
        onChanged: (String? newValue) {
          setState(() {
            selectedValue = newValue!;
          });
        },
        items: getRoleDropdownItems);
  }
}
