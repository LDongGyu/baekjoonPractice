class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        return genres.indices.groupBy { genres[it] } // {classic=[0,2,3], pop=[1,4]} Type : Map
            .toList() // [(classic, [0,2,3]),(pop,[1,4])] Type : List
            .sortedByDescending { it.second.sumBy { plays[it] } } // [(pop, [1,4]), (classic, [0,2,3])] Type : List
            .map { it.second.sortedByDescending { plays[it] }.take(2) } // [[4,1],[3,0]] Type : List
            .flatten() // [4, 1, 3, 0] Type : List
            .toIntArray() // [4, 1, 3, 0] Type : IntArray
    }
}