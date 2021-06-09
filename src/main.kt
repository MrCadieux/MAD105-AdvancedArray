fun main() {

    var choice: Int
    var totalItem: Int = 0
    var supplies = arrayOf("Soccer Balls", "Cones", "Pennies", "Whistles", "Pairs of Shoes" )
    var inventory = arrayOf("12", "20", "24", "2", "1")

    var soccerSupplies = arrayOf<Array<String>>()

    soccerSupplies += supplies
    soccerSupplies += inventory

    do{
        println("What would you like to do?")
        println("1: Display ALL inventory")
        println("2: Add inventory")
        println("3: Remove inventory")
        println("4: Exit")
        print("Please enter a number 1-4: ")
        choice = readLine()!!.toInt()

        when(choice){
            1 -> display(soccerSupplies)
            2 -> addItem(soccerSupplies)
            3 -> removeItem(soccerSupplies)
        }
        println()
    }while (choice!=4)

}

// Displays All inventory and total number of items
fun display(soccerSupplies: Array<Array<String>>){
    println("*****SOCCER INVENTORY*****")
    for (i in 0 .. soccerSupplies[0].size-1){
        println("${i+1}: ${soccerSupplies[0][i]}: ${soccerSupplies[1][i]}")
    }
    println("Total Items: ${totalNumItems(soccerSupplies)}")
}

// Adds and returns all items
fun totalNumItems(supplies: Array<Array<String>>): Int{  //This took some time to figure out
    var totalNum = 0
    for (i in 0 .. supplies[0].size-1){
        totalNum += supplies[1][i].toInt()
    }
    return totalNum
}

// Adds quantity to user specified item
fun addItem(items: Array<Array<String>>){
    var itemToAdd: Int
    var quantityToAdd: Int

    display(items)
    do {
        print("What items do you want to ADD: ")
        itemToAdd = readLine()!!.toInt()
        if (itemToAdd > items[0].size){
            println("Please enter a number 1-${items[0].size}")
        }
    }while (itemToAdd > items[0].size)


    print("How many ${items[0][itemToAdd-1]} do you want to ADD: ")
    quantityToAdd = readLine()!!.toInt()

    var newTotal = items[1][itemToAdd-1].toInt() + quantityToAdd
    items[1][itemToAdd-1] = newTotal.toString()

    println("You have ADDED $quantityToAdd ${items[0][itemToAdd-1]} brining the total to $newTotal")
}

fun removeItem(items: Array<Array<String>>){
    var itemToRemove: Int
    var quantityToRemove: Int

    display(items)
    do {
        print("What items do you want to REMOVE: ")
        itemToRemove = readLine()!!.toInt()
        if (itemToRemove > items[0].size){
            println("Please enter a number 1-${items[0].size}")
        }
    }while (itemToRemove > items[0].size)


    print("How many ${items[0][itemToRemove-1]} do you want to REMOVE: ")
    quantityToRemove = readLine()!!.toInt()

    var newTotal = items[1][itemToRemove-1].toInt() - quantityToRemove

    if (newTotal<0){
        println("There is not enough ${items[0][itemToRemove-1]} to remove $quantityToRemove")
        println("${items[0][itemToRemove-1]} has been set to 0")
        items[1][itemToRemove-1] = 0.toString()
    }
    else {
        items[1][itemToRemove - 1] = newTotal.toString()
    }

    println("You have REMOVED $quantityToRemove ${items[0][itemToRemove-1]} brining the total to $newTotal")

}