fun main() {
    fun part1(input: List<String>): Int {

        var nums = input[0].split(",").map { it.toInt() }
        var mat = mutableListOf<MutableList<MutableList<Int>>>()
        var row = mutableListOf<MutableList<Int>>()
        var column = mutableListOf<MutableList<Int>>()
        var count = 0
        for(i in 1 until input.size){
            if(input[i].isEmpty()){
                mat.add(mutableListOf())
                count++
            }else{
                var x =  input[i].trim()
                var item = x.split("\\s+".toRegex()).map (String::toInt)
                var new = item as MutableList<Int>
                mat[count-1].add(new)
                row.add(mutableListOf())
                row[count-1].add(5)
                column.add(mutableListOf())
                column[count-1].add(5)
            }
        }

        for(i in 0 until nums.size){
            for(j in 0 until mat.size){
                for(r in 0..4){
                    for(c in 0..4){
                        if(mat[j][r][c] == nums[i]){
                            row[j][r]--
                            column[j][c]--
                            var m = mat[j][r][c]
                            mat[j][r][c] = -1
                            if(row[j][r] == 0 || column[j][c] == 0){
                                var ans = 0
                                for(nr in 0..4){
                                    for(nc in 0..4){
                                        if(mat[j][nr][nc] != -1){
                                            ans += mat[j][nr][nc]
                                        }
                                    }
                                }
                                ans *= m
                                return ans
                            }
                        }
                    }
                }
            }
        }



        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    /*val testInput = readInput("Day01_test")
    check(part1(testInput) == 1)*/

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}
