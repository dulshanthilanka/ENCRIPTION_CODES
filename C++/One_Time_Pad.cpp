#include <iostream>
#include <string>
using namespace std;

string encription(string en_message, string en_key){
	string encripted_message = "";
	string alpherbet = "abcdefghijklmnopqrstuvwxyz";
	for(int i=0;i<en_message.length();i++){
		if(en_message.at(i)==' '){
		   encripted_message +=' ';
	    }else{
	       encripted_message += alpherbet.at((alpherbet.find(en_message.at(i))+alpherbet.find(en_key.at(i)))%26);	
		}
	}
	return encripted_message;
}

string decription(string de_message, string de_key){
	string decripted_message = "";
	string alpherbet = "abcdefghijklmnopqrstuvwxyz";
	for(int i=0;i<de_message.length();i++){
		if(de_message.at(i)==' '){
		   decripted_message +=' ';	
		}else{
		   decripted_message += alpherbet.at((alpherbet.find(de_message.at(i))-alpherbet.find(de_key.at(i))+26)%26);
		}
	}
	return decripted_message;
}

int main(){
	string message, key, send_key;
	cout<< "******************** THIS IS ONE TIME PAD CIPHER ENCRIPTION ********************"<<endl;
	cout<< endl;
	cout<< "ENTER THE MESSAGE YOU WANT TO ENCRIPT : ";
	getline(cin, message);
	cout<< "PLEASE ENTER A KEY WICH IS SAME AS MESSAGE LENGTH : ";
	getline(cin, key);
	int pos = 0;
	while(pos<1){
		if(message.length()==key.length()){
			send_key = key;
			pos++;
		}else{
			cout<<"PLEASE ENTER A KEY THAT HAVE SAME LENGTH AS MESSAGE : ";
			getline(cin, key);
			cout<< endl;
			pos=0;
		}
	}
	string encripted_message = encription(message, send_key);
	cout<<"ENCRIPTED MESSAGE IS : "<<encripted_message<< endl;
	cout<< endl;
	string decripted_message = decription(encripted_message, send_key);
	cout<< "DECRIPTED MESSAGE IS : "<<decripted_message<<endl;
	cout<< endl;
	return 0;
}
