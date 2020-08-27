import java.util.*

class Solution {
    fun solution(operations: Array<String>): IntArray {
        var answer = intArrayOf(0,0)

        var queueMin = PriorityQueue<Int>()
        var queueMax = PriorityQueue<Int>(Comparator.reverseOrder())

        for(i in 0..operations.size-1){
            var data = operations[i].split(" ")
            if(data[0].equals("I")){
                queueMin.offer(data[1].toInt())
            }
            else{
                if(data[1].equals("1")){
                    for(j in 0..queueMin.size-1){
                        queueMax.offer(queueMin.poll())
                    }
                    queueMax.poll()
                }
                else{
                    for(j in 0..queueMax.size-1){
                        queueMin.offer(queueMax.poll())
                    }
                    queueMin.poll()
                }
            }
        }
        
        for(i in 0..queueMax.size-1){
            queueMin.offer(queueMax.poll())
        }
        if(!queueMin.isEmpty()) {
            answer[1] = queueMin.poll()
        }


        for(i in 0..queueMin.size-1){
            queueMax.offer(queueMin.poll())
        }
        if(!queueMax.isEmpty()) {
            answer[0] = queueMax.poll()
        }

        return answer
    }
}

fun main(){
    var sol = Solution()
    var result= sol.solution(arrayOf("I 16","D 1"))

    print(result)
}