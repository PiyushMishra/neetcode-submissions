func twoSum(nums []int, target int) []int {

    seen := make(map[int]int)

    for index, num := range nums {
        remaining := target - num   
        if idx, exists := seen[remaining]; exists {
            return []int{idx, index}
        } else {
            seen[num] = index
        }
    }

    return []int{}
}
