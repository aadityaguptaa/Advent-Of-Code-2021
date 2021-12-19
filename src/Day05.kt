import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        var mat = HashMap<Int, MutableList<Int>>()
        var xMax = -1
        var yMax = -1

        for(i in 0 until input.size){
            var inp = input[i].split(" -> ")
            var a = inp[0].split(",")
            var b = inp[1].split(",")

            if(a[0].toInt() > xMax) xMax = a[0].toInt()
            if(b[0].toInt() > xMax) xMax = b[0].toInt()
            if(a[1].toInt() > yMax) yMax = a[1].toInt()
            if(b[1].toInt() > yMax) yMax = b[1].toInt()
        }
        for(i in 0..yMax){
            mat[i] = mutableListOf<Int>()
            for(j in 0..xMax){
                mat[i]?.add(0)
            }
        }

        for(i in 0 until input.size){
            var inp = input[i].split(" -> ")
            var a = inp[0].split(",")
            var b = inp[1].split(",")

            if(a[1].toInt() == b[1].toInt()){
                var ini = a[0].toInt()
                var end = b[0].toInt()
                if(ini > end){
                    var temp = ini
                    ini = end
                    end = temp
                }
                for(j in ini..end){
                    mat[a[1].toInt()]!![j]++
                }
            }else if(a[0].toInt() == b[0].toInt()){
                var ini = a[1].toInt()
                var end = b[1].toInt()
                if(ini > end){
                    var temp = ini
                    ini = end
                    end = temp
                }
                for(j in ini..end){
                    mat[j]!![a[0].toInt()]++
                }
            }

        }
        var count = 0
        for(i in 0..yMax){
            for(j in 0..xMax){
                if(mat[i]?.get(j)!! >= 2){
                    count++
                }
            }
        }


        return count
    }

    fun part2(input: List<String>): Int {
        var mat = HashMap<Int, MutableList<Int>>()
        var xMax = -1
        var yMax = -1

        for(i in 0 until input.size){
            var inp = input[i].split(" -> ")
            var a = inp[0].split(",")
            var b = inp[1].split(",")

            if(a[0].toInt() > xMax) xMax = a[0].toInt()
            if(b[0].toInt() > xMax) xMax = b[0].toInt()
            if(a[1].toInt() > yMax) yMax = a[1].toInt()
            if(b[1].toInt() > yMax) yMax = b[1].toInt()
        }
        for(i in 0..yMax){
            mat[i] = mutableListOf<Int>()
            for(j in 0..xMax){
                mat[i]?.add(0)
            }
        }

        for(i in 0 until input.size){
            var inp = input[i].split(" -> ")
            var a = inp[0].split(",")
            var b = inp[1].split(",")

            if(a[1].toInt() == b[1].toInt()){
                var ini = a[0].toInt()
                var end = b[0].toInt()
                if(ini > end){
                    var temp = ini
                    ini = end
                    end = temp
                }
                for(j in ini..end){
                    mat[a[1].toInt()]!![j]++
                }
            }else if(a[0].toInt() == b[0].toInt()){
                var ini = a[1].toInt()
                var end = b[1].toInt()
                if(ini > end){
                    var temp = ini
                    ini = end
                    end = temp
                }
                for(j in ini..end){
                    mat[j]!![a[0].toInt()]++
                }
            }else{
                var x1 = a[0].toInt()
                var x2 = b[0].toInt()
                var y1 = a[1].toInt()
                var y2 = b[1].toInt()
                if(abs(x1 - x2) == abs(y1 - y2)){
                    //a1 < b1; a2 < b2
                    if(x1 < x2 && y1 < y2){
                        var co = 0
                        for(q in x1..x2){
                            mat[y1+co]!![q]++
                            co++
                        }
                    }else if(x1 < x2 && y1 > y2) {
                        var co = 0
                        for (q in x1..x2) {
                            mat[y1 - co]!![q]++
                            co++
                        }
                    }else if(x1 > x2 && y1 < y2){
                        var co = 0
                        for(q in x2..x1){
                            mat[y2-co]!![q]++
                            co++
                        }
                    }else if(x1 > x2 && y1 > y2){
                        var co = 0
                        for(q in x2..x1){
                            mat[y2+co]!![q]++
                            co++
                        }
                    }

                }
            }

        }
        var count = 0
        for(i in 0..yMax){
            for(j in 0..xMax){
                if(mat[i]?.get(j)!! >= 2){
                    count++
                }
            }
        }
        for(k in 0 until mat.size){
            println(mat[k])
        }


        return count
    }

    // test if implementation meets criteria from the description, like:
    /*val testInput = readInput("Day01_test")
    check(part1(testInput) == 1)*/

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}
