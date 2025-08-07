
import java.util.Arrays;
public class Binarysearchquespart3 {
    public static void main(String[] args) {
        int arr[] = {12, 34, 67, 90};
        int arr2[] = {1,2,3,4,5,6,7,8,9,10};
        int answer = bookallocation(2, arr);
        System.out.println(answer);
        int ans2 = shipment(5, arr2);
        System.out.println(ans2);
        int arr3[] = {3,6,7,11};
        kokoeating(arr3, 8);
        int arr4[] = {44,22,33,11,1};
        smallestDivisor(arr4, 5);
        int []quantities = {11,6};
        int result1 = minimizedMaximum(6 , quantities);
        System.out.println(result1);
        int stalls[] = {1, 2, 4, 8, 9};
        System.out.println(aggressivecows(stalls , 3));



        

    }



//Allocate Minimum Pages

//Question demand : 
//1. Every student must get atleast one book
//2. Each book must be allocated to exactly one student ( no sharing allowed).
//3. Allocation should be in contiguous fashion.

//Eg : [12,34,67,90] is to be divided among 2 students A and B.
//1st combination would be : A->12,34,67 = 113 and B->90
//2nd combination would be : A->12,34 = 46 and B->67,90 = 157
//3rd combination would be : A-> 12 and B-> 34,67,90 = 191
//So the minimum of all the maximums is 113 hence that is the answer. 

//Logic: 
//1. We cannot apply Binary search on the array given since it's not sorted, We apply binary search on the range 
//of our answer which is actually the range of maximum pages alloted to a student to read. 
//2. Let's assume the number of student to be 1 , so if he can read only one book with the max pages
//he would read 90 pages , similarily if he gets to read all the pages he can read 203
//3. The range is (90---------203).
//4. The range is basically from the max element of the array and the sum of all elements in the array. 

//Approach: 
//The base condition would be if there are more students than the no. of books so return -1.
//now first calculate the max and the sum of the array in a single loop such that start points to the max and end points to the sum
//We have our range now , apply Binary search on the range.
//Check if the mid element is valid by checking if that's the maximum amount of pages that can be read by a student.

 
public static int bookallocation(int students , int []books)
{
    int res = -1;
    if(books.length < students)
    {
        return res;
    }
    // range will be max of array and sum of array 
    int start = Integer.MIN_VALUE ; // this will point to the max of array
    int end = 0; // this is the sum of array

    for(int i = 0 ; i < books.length ; i++)
    {
        if(books[i] > start)
        {
            start = books[i];
        }
        end = end+books[i];
    }

    while(start <= end)
    {
        int mid = (start + (end-start)/2);
        if(isbookallocation(mid,students,books))
        {

            res = mid;
            end = mid-1;
        }
        else
        {
            start = mid+1;
        }
    }
    return res;

}
static boolean isbookallocation(int maxpages,int students ,int []books)
{
    int currentstudent = 1;
    int pages = 0;
    for(int i = 0 ; i < books.length ; i++)
    {
        pages += books[i];
        //if pages exceed max pages
        if(pages > maxpages)
        { //allocate to next student
            currentstudent++;
            pages = books[i];
        }
        if(currentstudent > students)
        {
            return false;
        }

    }
    return true;

}

//Capacity To Ship Packages Within D Days

//Logic : 
//Similar approach as books allocation question.
//We apply binary search on the range of our answer.
//The range is from the max element of the array to the sum of the array.

//Approach:
//First calculate the max and the sum of the array in a single loop such that start points to the max and end points to the sum.
//We have our range now , apply Binary search on the range.
//Check if the mid element is valid by checking if that's the maximum amount of weight that can be shipped on that day.

public static int shipment(int days , int []weights)
{
    int res = -1;

    // range will be max of array and sum of array 
    int start = Integer.MIN_VALUE ; // this will point to the max of array
    int end = 0; // this is the sum of array

    for(int i = 0 ; i < weights.length ; i++)
    {
        if(weights[i] > start)
        {
            start = weights[i];
        }
        end = end+weights[i];
    }

    while(start <= end)
    {
        int mid = (start + (end-start)/2);
        if(isshipmentpossible(mid,days,weights))
        {

            res = mid;
            end = mid-1;
        }
        else
        {
            start = mid+1;
        }
    }
    return res;

}
static boolean isshipmentpossible(int maxweights,int days ,int []weights)
{
    int currentday = 1;
    int capacity = 0;
    for(int i = 0 ; i < weights.length ; i++)
    {
        capacity+= weights[i];
        //if capacity exceed max weight
        if(capacity > maxweights)
        { //allocate to next day
            currentday++;
            capacity = weights[i];
        }
        if(currentday > days)
        {
            return false;
        }

    }
    return true;

}


//Koko Eating Bananas

//Question demands:
//Koko can only eat atmost k bananas in 1 hour from only one pile
//For eg: [3,6,7,11] with the capacity of 4.
//So 3 is smaller than koko's capacity but it won't move on to the next pile in that hour. 
//So 1st pile would take 1 , 2nd would take 2 and so on.

//Logic:
//1. Binary search would be applied on answer.
//2. The minimum capacity would be 1 and the max would be 11 since koko can only eat from one pile in an hour.
//3. Therefore the range would be 1---11.


//Approach:
//1. The range would be from 1 to the max element of the array.
//2. Apply binary search and check if the mid element is the possible eating rate of koko.
//3. The condition for the eating rate to be possible is if the piles/eating rate is equal or less than hours given.

static void kokoeating(int[]piles , int h)
{
    int res = -1;
    int start = 1;
    int end = Integer.MIN_VALUE;

    for(int i = 0 ; i < piles.length ; i++)
    {
        if(piles[i]>end)
        {
            end = piles[i];
        }
    }

    while(start <= end)
    {
        int mid = (start+(end-start)/2);
        if(ispossible(mid , h , piles))
        {
            end = mid-1;
            res = mid;
        }
        else
        {
            start = mid+1;
        }
    }
    System.out.println(res);


}
static boolean ispossible(int max , int hours , int[]piles)
{
    int ans = 0 ;
    for(int i = 0 ; i < piles.length ; i++)
    { 
        ans += (piles[i]/max);
        if(piles[i]%max != 0)
        {
            ans += 1;
        }
    }
    if(ans > hours)
    {
        return false;
    }
    return true;
}


//Find the Smallest Divisor Given a Threshold

//Logic : Same as Koko eating Bananas.

//Approach:
//1. The range would be from 1 to the max element of the array.
//2. Apply binary search and check if the mid element is the possible smallest divisor.
//3. The condition for the divisor to be the smallest is if the sum of (numbers of the array /divisor) is equal or less than threshold given.

static void smallestDivisor(int[] nums, int threshold) {
        int start = 1; 
        int end = Integer.MIN_VALUE;
        int res = -1;

        for(int i = 0 ; i < nums.length ; i++)
        {
            if(nums[i]>end)
            {
                end = nums[i];
            }
        }

        while(start <= end)
        {
            int mid = (start+(end-start)/2);
            if(ismidvalid(mid , threshold , nums))
            {
                end = mid-1;
                res = mid;
            }
            else
            {
                start = mid+1;
            }
        }
        System.out.println(res);
        
    }
    static boolean ismidvalid(int divisor , int threshold , int[] nums)
    {
        long ans = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            ans += nums[i]/divisor;
            if(nums[i]%divisor != 0)
            {
                ans += 1;
            }
            if(ans > threshold)
            {
                return false;
            }
        }
        return true;
    }

//Minimized Maximum of Products Distributed to Any Store.

//Question demands:
//1. Stores can be given 0 products.
//2. One store can atmost be given only one product type.

//Logic : 
//1. Binary search would be applied on the range of our answer.
//For eg. the product quantities is given as : [11,6]
//2. The minimum amount of product given could be 0 but we won't consider 0 and start from 1 , the max would be 11.
//3. We get our range that is from 1---11.
//4. Therefore our range lies between the minimum product that can be given to the maximum element in the array.

//Approach:
//1. The range would be from 1 to the max element of the array.
//2. Apply binary search and check if the mid element is the possible smallest maximum.
//3. The condition for the number to be the smallest is if (quantities of the product /mid) is equal or less than the no. of shops given.

 static int minimizedMaximum(int n, int[] quantities) {

        int start = 1 ; 
        int res = -1;
        int end = Integer.MIN_VALUE;
        int size = quantities.length;

        for(int i = 0 ; i < size ; i ++)
        {
            if(end < quantities[i])
            {
                end = quantities[i];
            }
        }

        while(start <= end)
        {
            int mid = start+(end-start)/2;
            if(ispossible(n,quantities,mid))
            {
                res = mid;
                end = mid-1;
            }
            else
            {
                start = mid+1;
            }
        }
        return res;
        
    }

    static boolean ispossible(int shops , int[] quantities, int max)
    {
        int distribution = 0 ;

        for(int i = 0 ; i < quantities.length ; i++)
        {
            distribution += quantities[i]/max;
            if(quantities[i]%max != 0)
            {
                distribution += 1;
            }

            if(distribution > shops)
            {
                return false;
            }

        }
        return true;
    }

//Aggressive Cows  

//Question :
//1. An array of stalls is given where the location of the stalls is marked.
//2. The No. of cows are also given. 
//3. Task is to assign stalls to k cows such that the minimum distance between any two of them is the maximum possible.

//Eg: 
//stalls[] = [1, 2, 4, 8, 9]  
//k = 3
//therefore there are multiple methods to assign these cows in stalls 

//  1  |  2  |  4  |  8  |  9   
//  c1 |  c2 |  c3 |     |       --> 1 minimum space (2-1)
//  c1 |     |  c2 | c3  |       --> 3 minimum space (4-1)
//  c1 |     |  c2 |     | c3    --> 3 minimum space (4-1)
//     |     |     |     |
//     |     |     |     |
//     |     |     |     | 
//     |     |     |     |

//therefore the maximum among these would be the answer.


//Logic :
//1. Binary search would be applied on the answer range.
//2. Range for this question would be the minimum distance that is possible which is 1 and the maximum distance possible 
//which would be the difference between the minimum element of the array and the max element.
//3. Array also need to be sorted , if its not then the minimum difference between any two cows won't be calculated easily.

static int aggressivecows(int[] stalls, int cows)
{
    if(stalls.length < cows)
    {
        return -1;
    }
    Arrays.sort(stalls);
    int start = 1;
    int end = stalls[stalls.length-1] - stalls[0];
    int res = -1;
    
    while(start <= end)
    {
        int mid = start+(end-start)/2;
        if(iscowallocation(stalls,cows,mid))
        {
            res = mid;
            start = mid+1;
        }
        else
        {
        end = mid-1;
        }
    }
    return res;
}

static boolean iscowallocation(int[] stalls,int cows,int mindistance)
{
    int cowscount = 1;
    int lastcowdistance = stalls[0];
    for(int i = 1 ; i < stalls.length; i++)
    {
        if(stalls[i] - lastcowdistance >= mindistance)
        {
            cowscount++;
            lastcowdistance = stalls[i];
        }
        if(cowscount >= cows)
        {
            return true;
        }
        
    }
    
    return false;
        
}







}

