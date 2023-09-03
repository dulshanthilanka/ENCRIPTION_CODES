#include <iostream>
#include <string>
using namespace std;

string encription(string recived_message, int value) {
    string alphabet = "abcdefghijklmnopqrstuvwxyz";
    string encrypted_message = "";
    for (int i = 0; i < recived_message.length(); i++) {
        if (recived_message.at(i) == ' ') {
            encrypted_message += ' ';
        } else {
            encrypted_message += alphabet.at((alphabet.find(recived_message.at(i)) + value) % 26);
        }
    }
    return encrypted_message;
}

string decription(string recevid_encripted_message, int value) {
    string alphabet = "abcdefghijklmnopqrstuvwxyz";
    string decripted_message = "";
    for (int i = 0; i < recevid_encripted_message.length(); i++) {
        if (recevid_encripted_message.at(i) == ' ') {
            decripted_message += ' ';
        } else {
            decripted_message += alphabet.at(((alphabet.find(recevid_encripted_message.at(i)) - value + 26) % 26));
        }
    }
    return decripted_message;
}

int main() {
    string message;
    int value;
    cout << "***************************** WELCOME TO CAESAR CIPHER ALGORITHM **********************************" << endl;
    cout << endl;
    cout << "ENTER THE MESSAGE THAT YOU WANT TO ENCRYPT : ";
    getline(cin, message);
    cout << endl;
    cout << "ENTER THE KEY VALUE FOR ENCRYPTION AND DECRYPTION : ";
    cin >> value;
    cout << endl;

    string return_encripted_message = encription(message, value);
    cout << "ENCRYPTED MESSAGE IS : " << return_encripted_message << endl;
    cout << endl;
    string return_decripted_message = decription(return_encripted_message, value);
    cout << "DECRYPTED MESSAGE IS : " << return_decripted_message << endl;
    return 0;
}

