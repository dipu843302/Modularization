package com.example.data

class GetName(model:Model) {

    companion object{
        lateinit var modelInterface: Model
    }
    init{
      modelInterface=model
    }
}

