import json
class Tamagotch():
    def __init__(self, nome, foodBar, funBar, cleanBar, energyBar, message, face):
        self.nome = nome
        self.foodBar = foodBar
        self.funBar = funBar
        self.cleanBar = cleanBar
        self.energyBar = energyBar
        self.message = message
        self.face = face

    # def __init__(self, json_conv):
    #     self.nome = json_conv["nome"]
    #     self.foodBar = json_conv["food"]
    #     self.funBar = json_conv["fun"]
    #     self.cleanBar = json_conv["clean"]
    #     self.energyBar = json_conv["energy"]
    #     self.message =  json_conv["message"]
    #     self.face =  json_conv["face"]



    
    