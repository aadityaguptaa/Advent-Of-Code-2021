fun main() {
    fun part1(input: List<String>): Int {
        var arr = mutableListOf<Int>(0,0,0,0,0,0,0,0,0,0,0,0)
        for(i in input){
            for(j in 0..11){
                if(i[j] == '1'){
                    arr[j]++;
                }
            }
        }
        var gamma = ""
        var epsilon = ""
        for(i in 0..11){
            if(arr[i] > input.size - arr[i]){
                gamma += "1"
                epsilon += "0"
            }else{
                gamma += "0"
                epsilon += "1"
            }
        }
        return (gamma.toInt(2)*epsilon.toInt(2))
    }

    fun part2(input: List<String>): Int {
        var oxygen = ""
        var co2 = ""
        var temp = input.toMutableList()
        var counter = 0
        while (temp.size != 1){

            var arr = mutableListOf<Int>()
            for(i in 0 until temp[0].length){
                arr.add(0)
            }
            for(i in temp){
                for(j in i.indices){
                    if(i[j] == '1'){
                        arr[j]++
                    }
                }
            }
            if(arr[counter] >= temp.size-arr[counter]){
                for(i in 0 until temp.size){
                    if(temp[i][counter] != '1'){
                        temp[i] = "-1"
                    }
                }
            }else{
                for(i in 0 until temp.size){
                    if(temp[i][counter] != '0'){
                        temp[i] = "-1"
                    }
                }
            }
            var temp2 = mutableListOf<String>()
            for(i in temp){
                if(i != "-1"){
                    temp2.add(i)
                }
            }
            temp = temp2
            counter++
            if(counter>=12){
                break
            }
        }
        println(temp)
        oxygen = temp[0]
        var temp3 = input.toMutableList()
        counter = 0


        while (temp3.size != 1){

            var arr = mutableListOf<Int>()
            for(i in 0 until temp3[0].length){
                arr.add(0)
            }
            for(i in temp3){
                for(j in i.indices){
                    if(i[j] == '1'){
                        arr[j]++
                    }
                }
            }
            if(arr[counter] >= temp3.size-arr[counter]){
                for(i in 0 until temp3.size){
                    if(temp3[i][counter] != '0'){
                        temp3[i] = "-1"
                    }
                }
            }else{
                for(i in 0 until temp3.size){
                    if(temp3[i][counter] != '1'){
                        temp3[i] = "-1"
                    }
                }
            }
            var temp2 = mutableListOf<String>()
            for(i in temp3){
                if(i != "-1"){
                    temp2.add(i)
                }
            }
            temp3 = temp2
            counter++
            if(counter>=12){
                break
            }
        }
        co2 = temp3[0]
        println(temp3)
        return (oxygen.toInt(2)*co2.toInt(2))
    }

    // test if implementation meets criteria from the description, like:
    /*val testInput = readInput("Day01_test")
    check(part1(testInput) == 1)*/

    val input = readInput("Day03")
    //println(part1(input))
    println(part2(input))
}
