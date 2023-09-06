#include <iostream>
#include <string>
using namespace std;

string keymaking(string message,string key){
	string modifiedkey = "";
	for(int i=0;i<message.length();i++){
	modifiedkey += key.at(i%key.length());	
	}
	return modifiedkey;
}

string encription(string message, string modifiedkey){
	string encripted_message = "";
	string alpherbet = "abcdefghijklmnopqrstuvwxyz";
	for(int i=0;i<message.length();i++){
		if(message.at(i) == ' '){
		   encripted_message += ' ';	
		}else if (message.at(i) == '.') {
            encripted_message += '.';
        }else if (message.at(i) == ',') {
            encripted_message += ',';
		 }else if (message.at(i) == '"') {
            encripted_message += '"';
		 }else if (message.at(i) == '1') {
            encripted_message += '1';
		 }else if (message.at(i) == '2') {
            encripted_message += '2';
		 }else if (message.at(i) == '3') {
            encripted_message += '3';
		 }else if (message.at(i) == '4') {
            encripted_message += '4';
		 }else if (message.at(i) == '5') {
            encripted_message += '5';
		 }else if (message.at(i) == '6') {
            encripted_message += '6';
		 }else if (message.at(i) == '7') {
            encripted_message += '7';
		 }else if (message.at(i) == '8') {
            encripted_message += '8';
		 }else if (message.at(i) == '9') {
            encripted_message += '9';
		 }else if (message.at(i) == '/') {
            encripted_message += '/';
		 }else if (message.at(i) == '?') {
            encripted_message += '?';
		 }else if (message.at(i) == '(') {
            encripted_message += '(';
		 }else if (message.at(i) == ')') {
            encripted_message += ')';
		 }else{
		    encripted_message += alpherbet.at((alpherbet.find(message.at(i))+alpherbet.find(modifiedkey.at(i)))%26);
		}
	}
	return encripted_message;
}

string decription(string message, string modifiedkey){
	string decripted_message = "";
	string alpherbet = "abcdefghijklmnopqrstuvwxyz";
	for(int i=0;i<message.length();i++){
		if(message.at(i) == ' '){
			decripted_message += ' ';
		}else if (message.at(i) == '.') {
            decripted_message += '.';
        }else if (message.at(i) == ',') {
            decripted_message += ',';
		 }else if (message.at(i) == '"') {
            decripted_message += '"';
		 }else if (message.at(i) == '1') {
            decripted_message += '1';
		 }else if (message.at(i) == '2') {
            decripted_message += '2';
		 }else if (message.at(i) == '3') {
            decripted_message += '3';
		 }else if (message.at(i) == '4') {
            decripted_message += '4';
		 }else if (message.at(i) == '5') {
            decripted_message += '5';
		 }else if (message.at(i) == '6') {
            decripted_message += '6';
		 }else if (message.at(i) == '7') {
            decripted_message += '7';
		 }else if (message.at(i) == '8') {
            decripted_message += '8';
		 }else if (message.at(i) == '9') {
            decripted_message += '9';
		 }else if (message.at(i) == '/') {
            decripted_message += '/';
		 }else if (message.at(i) == '?') {
            decripted_message += '?';
		 }else if (message.at(i) == '(') {
            decripted_message += '(';
		 }else if (message.at(i) == ')') {
            decripted_message += ')';
		 }else{
			decripted_message += alpherbet.at((alpherbet.find(message.at(i))-alpherbet.find(modifiedkey.at(i))+26)%26);
		}
	}
	return decripted_message;
}

int main(){
	string message;
    string key;
    cout << "***************************** WELCOME TO POLYALPHABETIC CIPHER ALGORITHM **********************************" << endl;
    cout << endl;
    cout << "ENTER THE MESSAGE THAT YOU WANT TO ENCRYPT : ";
    getline(cin, message);
    cout << endl;
    cout << "ENTER THE KEY : ";
    getline(cin, key);
    string modifiedkey = keymaking(message, key);
    string encripted_message = encription(message, modifiedkey);
    cout << "ENCRIPTED MESSAGE IS : "<<encripted_message<<endl;
    cout << endl;
    string decripted_message = decription(encripted_message, modifiedkey);
    cout << "DECRIPTED MESSAGE IS : "<<decripted_message<<endl;
	return 0;
}
