#include <iostream>
#include <string>
using namespace std;

string encription(string recived_message){
	string alphabet = "abcdefghijklmnopqrstuvwxyz";
	string salphabet = "qwertyuiopasdfghjklzxcvbnm";
	string encripted_message = "";
	for(int i=0;i<recived_message.length();i++){
		if(recived_message.at(i) == ' ') {
            encripted_message += ' ';
        }else if (recived_message.at(i) == '.') {
            encripted_message += '.';
        }else if (recived_message.at(i) == ',') {
            encripted_message += ',';
		 }else if (recived_message.at(i) == '"') {
            encripted_message += '"';
		 }else if (recived_message.at(i) == '1') {
            encripted_message += '1';
		 }else if (recived_message.at(i) == '2') {
            encripted_message += '2';
		 }else if (recived_message.at(i) == '3') {
            encripted_message += '3';
		 }else if (recived_message.at(i) == '4') {
            encripted_message += '4';
		 }else if (recived_message.at(i) == '5') {
            encripted_message += '5';
		 }else if (recived_message.at(i) == '6') {
            encripted_message += '6';
		 }else if (recived_message.at(i) == '7') {
            encripted_message += '7';
		 }else if (recived_message.at(i) == '8') {
            encripted_message += '8';
		 }else if (recived_message.at(i) == '9') {
            encripted_message += '9';
		 }else if (recived_message.at(i) == '/') {
            encripted_message += '/';
		 }else if (recived_message.at(i) == '?') {
            encripted_message += '?';
		 }else if (recived_message.at(i) == '(') {
            encripted_message += '(';
		 }else if (recived_message.at(i) == ')') {
            encripted_message += ')';
		 }
		 else {
		 	encripted_message += salphabet.at(alphabet.find(recived_message.at(i)));
        }	
	}
	return encripted_message;
}

string decription(string recived_encripted_message){
	string alphabet = "abcdefghijklmnopqrstuvwxyz";
	string salphabet = "qwertyuiopasdfghjklzxcvbnm";
	string decripted_message = "";
	for(int i=0;i<recived_encripted_message.length();i++){
		
		
		
		if (recived_encripted_message.at(i) == ' ') {
            decripted_message += ' ';
        }else if (recived_encripted_message.at(i) == '.') {
            decripted_message += '.';
        }else if (recived_encripted_message.at(i) == ',') {
            decripted_message += ',';
		 }else if (recived_encripted_message.at(i) == '"') {
            decripted_message += '"';
		 }else if (recived_encripted_message.at(i) == '1') {
            decripted_message += '1';
		 }else if (recived_encripted_message.at(i) == '2') {
            decripted_message += '2';
		 }else if (recived_encripted_message.at(i) == '3') {
            decripted_message += '3';
		 }else if (recived_encripted_message.at(i) == '4') {
            decripted_message += '4';
		 }else if (recived_encripted_message.at(i) == '5') {
            decripted_message += '5';
		 }else if (recived_encripted_message.at(i) == '6') {
            decripted_message += '6';
		 }else if (recived_encripted_message.at(i) == '7') {
            decripted_message += '7';
		 }else if (recived_encripted_message.at(i) == '8') {
            decripted_message += '8';
		 }else if (recived_encripted_message.at(i) == '9') {
            decripted_message += '9';
		 }else if (recived_encripted_message.at(i) == '/') {
            decripted_message += '/';
		 }else if (recived_encripted_message.at(i) == '?') {
            decripted_message += '?';
		 }else if (recived_encripted_message.at(i) == '(') {
            decripted_message += '(';
		 }else if (recived_encripted_message.at(i) == ')') {
            decripted_message += ')';
		 }else {
		 	decripted_message += alphabet.at(salphabet.find(recived_encripted_message.at(i)));
        }
	}
	return decripted_message;
}

int main(){
	string message;
    int value;
    cout << "***************************** WELCOME TO MONOALPHABETIC CIPHER ALGORITHM **********************************" << endl;
    cout << endl;
    cout << "ENTER THE MESSAGE THAT YOU WANT TO ENCRYPT : ";
    getline(cin, message);
    cout << endl;

    string return_encripted_message = encription(message);
    cout << "ENCRYPTED MESSAGE IS : " << return_encripted_message << endl;
    cout << endl;
    string return_decripted_message = decription(return_encripted_message);
    cout << "DECRYPTED MESSAGE IS : " << return_decripted_message << endl;
	return 0;
}
