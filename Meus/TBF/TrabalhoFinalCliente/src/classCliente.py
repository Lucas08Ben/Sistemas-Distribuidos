import socket, select
import sys


class Cliente():
    def __init__(self, HOST, PORT):
        self.LOCAL = (HOST, PORT)
        self.socketClient = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        self.socketClient.connect(self.LOCAL)
           

    def doOperation(self, msg):
        
        self.socketClient.send(bytes(msg + "\r\ntrue)", 'UTF-8'))
        # print(msg)
        # print(self.socketClient)  
        return self.socketClient.recv(1024).decode(encoding = 'UTF-8')

    def fechaConexao(self):
        self.socketClient.close()

