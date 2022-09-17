import 'package:flutter/material.dart';

void main() {
  runApp(const AdminFeatures());
}

class AdminFeatures extends StatefulWidget {
  const AdminFeatures({Key? key}) : super(key: key);

  @override
  State<AdminFeatures> createState() => _AdminFeaturesState();
}

class _AdminFeaturesState extends State<AdminFeatures> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        debugShowCheckedModeBanner: false,
        home: Scaffold(
            appBar: AppBar(
              title: const Text(
                'Admin Panel',
                style: TextStyle(color: Colors.black),
              ),
              centerTitle: true,
              backgroundColor: Colors.white,
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
            body: const FirstScreen(),
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
            )));
  }
}

class FirstScreen extends StatelessWidget {
  const FirstScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      crossAxisAlignment: CrossAxisAlignment.center,
      children: [
        Padding(
          padding: const EdgeInsets.all(45),
          child: OutlinedButton(
            style: OutlinedButton.styleFrom(
              minimumSize: const Size(300, 50),
              maximumSize: const Size(300, 50),
            ),
            child: const Text(
              "Account Management",
              style: TextStyle(fontSize: 25.0),
            ),
            onPressed: () {},
          ),
        ),
        Padding(
          padding: const EdgeInsets.all(45),
          child: OutlinedButton(
            style: OutlinedButton.styleFrom(
              minimumSize: const Size(300, 50),
              maximumSize: const Size(300, 50),
            ),
            child: const Text(
              "Account Creation",
              style: TextStyle(fontSize: 25.0),
            ),
            onPressed: () => Navigator.of(context).push(MaterialPageRoute(
                builder: (context) => const AccountCreation())),
          ),
        ),
        Padding(
          padding: const EdgeInsets.all(45),
          child: OutlinedButton(
            style: OutlinedButton.styleFrom(
              minimumSize: const Size(300, 50),
              maximumSize: const Size(300, 50),
            ),
            child: const Text(
              "Data Generation",
              style: TextStyle(fontSize: 25.0),
            ),
            onPressed: () => Navigator.of(context).push(MaterialPageRoute(
                builder: (context) => const DataGeneration())),
          ),
        ),
      ],
    );
  }
}

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
        body: Padding(
          padding: const EdgeInsets.all(15),
          child: ListView(children: const <Widget>[
            Padding(
              padding: EdgeInsets.all(15),
              child: TextField(
                decoration: InputDecoration(
                  border: OutlineInputBorder(),
                  labelText: 'First Name',
                  hintText: 'Enter Your First Name',
                ),
              ),
            ),
            Padding(
              padding: EdgeInsets.all(15),
              child: TextField(
                decoration: InputDecoration(
                  border: OutlineInputBorder(),
                  labelText: 'Last Name',
                  hintText: 'Enter Last Name',
                ),
              ),
            ),
            Padding(
              padding: EdgeInsets.all(15),
              child: TextField(
                decoration: InputDecoration(
                  border: OutlineInputBorder(),
                  labelText: 'Email',
                  hintText: 'Enter Email',
                ),
              ),
            ),
            Padding(
              padding: EdgeInsets.all(15),
              child: TextField(
                decoration: InputDecoration(
                  border: OutlineInputBorder(),
                  labelText: 'Phone Number',
                  hintText: 'Enter Phone Number',
                ),
              ),
            ),
            Padding(
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
            Padding(
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
            Padding(
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
            Padding(padding: EdgeInsets.all(15), child: GenderDropdownItem()),
            Padding(
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
            Padding(
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
            Padding(padding: EdgeInsets.all(15), child: UserDropdownItem())
          ]),
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

class DataGeneration extends StatefulWidget {
  const DataGeneration({Key? key}) : super(key: key);

  @override
  State<DataGeneration> createState() => _DataGenerationState();
}

class _DataGenerationState extends State<DataGeneration> {
  TextEditingController textEditingController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          backgroundColor: Colors.grey,
          title: const Text(
            'Data Generation',
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
        body: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            Padding(
              padding: const EdgeInsets.all(45),
              child: OutlinedButton(
                style: OutlinedButton.styleFrom(
                  minimumSize: const Size(300, 50),
                  maximumSize: const Size(300, 50),
                ),
                child: const Text(
                  "Appointment Data",
                  style: TextStyle(fontSize: 25.0),
                ),
                onPressed: () {},
              ),
            ),
            Padding(
              padding: const EdgeInsets.all(45),
              child: OutlinedButton(
                  style: OutlinedButton.styleFrom(
                    minimumSize: const Size(300, 50),
                    maximumSize: const Size(300, 50),
                  ),
                  child: const Text(
                    "Payment Data",
                    style: TextStyle(fontSize: 25.0),
                  ),
                  onPressed: () => {}),
            ),
            Padding(
              padding: const EdgeInsets.all(45),
              child: OutlinedButton(
                  style: OutlinedButton.styleFrom(
                    minimumSize: const Size(300, 50),
                    maximumSize: const Size(300, 50),
                  ),
                  child: const Text(
                    "Account Data",
                    style: TextStyle(fontSize: 25.0),
                  ),
                  onPressed: () => {}),
            ),
          ],
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
