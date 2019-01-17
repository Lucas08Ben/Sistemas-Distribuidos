from classTamagotch import Tamagotch
from classCliente import Cliente
import json

def toJson(action, tmg):
    js = {
        'action' : action,
        'nome'   : tmg.nome,
        'food'   : tmg.foodBar,
        'fun'    : tmg.funBar,
        'clean'  : tmg.cleanBar,
        'energy' : tmg.energyBar,
        'message': tmg.message,
        'face'   : tmg.face
    }
    return json.dumps(js)

def tamagotchToString(tmg):
        tStr = tmg.nome + ' ' + str(tmg.foodBar) + ' ' + str(tmg.funBar) + ' ' +  str(tmg.cleanBar) + ' ' + str(tmg.energyBar) + ' ' + tmg.message + ' ' + tmg.face
        return tStr

def toString(tmg):
        tStr = 'Nome: ' + tmg.nome + ', Alimentacao: ' + str(tmg.foodBar) + ', Diversao: ' + str(tmg.funBar) + ', Higiene: ' +  str(tmg.cleanBar) + ', Energia: ' + str(tmg.energyBar) + ', Mensagem: ' + tmg.message + '\nFace:\n' + tmg.face
        return tStr

def toTamagotch(resp):
        json_conv = json.loads(resp)
        nome      = json_conv["nome"]
        food      = json_conv["food"]
        fun       = json_conv["fun"]
        clean     = json_conv["clean"]
        energy    = json_conv["energy"]
        message   = json_conv["message"]
        face      = json_conv["face"]

        return Tamagotch(nome, food, fun, clean, energy, message, face)


###################################################################################################
###################################################################################################
###################################################################################################

def born(tmg):
    json_born = {
        'action': 'born',
        'nome': tmg,
    }
    json_conv = json.dumps(json_born)
    resp = C.doOperation(json_conv)
    return toTamagotch(resp)
    
def feed(tmg):
    js = toJson("feed", tmg)
    resp = C.doOperation(js)
    return toTamagotch(resp)
    
def play(tmg):
    js = toJson("play", tmg)
    resp = C.doOperation(js)
    return toTamagotch(resp)


def bathe(tmg):
    js = toJson("bathe", tmg)
    resp = C.doOperation(js)
    return toTamagotch(resp)


def let_rest(tmg):
    js = toJson("let_rest", tmg)
    resp = C.doOperation(js)
    return toTamagotch(resp)


def give_affection(tmg):
    js = toJson("give_affection", tmg)
    resp = C.doOperation(js)
    return toTamagotch(resp)


def current_status(tmg):
    js = toJson("current_status", tmg)
    resp = C.doOperation(js)
    return toTamagotch(resp)



if __name__ == "__main__":
    C = Cliente('127.0.0.1', 5678)
    print ("Seja bem-vindo ao Tamagotch")
    
    nome = input("Insira o nome do seu bichinho\n")

    tmg = born(nome)
    
    print(toString(tmg))

    keep = True

    while keep:
        print ("O que deseja fazer agora ?")
        opcao = input("1-Alimentar\t2-Brincar\n3-Dar banho\t4-Colocar para dormir\n5-Conversar\t6-Status\n0-Sair\n")
        
        if(opcao == "1"):
            # tmg = Tamagotch("michel", 100, 100, 100, 100, "hola", "abudaduda")
            # print(toString(tmg))
            tmg = feed(tmg)

        elif(opcao == "2"):
            tmg = play(tmg)

        elif(opcao == "3"):
            tmg = bathe(tmg)

        elif(opcao == "4"):
            tmg = let_rest(tmg)

        elif(opcao == "5"):
            tmg = give_affection(tmg)

        elif(opcao == "6"):
            tmg = current_status(tmg)
            
            
        elif(opcao == "0"):
            close = {
                'action':'close'
            }
            js = json.dumps(close)
            resp = C.doOperation(js)
            js = json.loads(resp)
            nome = js["nome"]
            if nome ==  'close':
                C.socketClient.close()
                break    

        else:
            print ("Por favor, escolha um opção válida")

        print(toString(tmg))







    


