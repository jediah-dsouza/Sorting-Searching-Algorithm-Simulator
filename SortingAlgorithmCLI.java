import java.util.Arrays;
import java.util.Scanner;

public class SortingAlgorithmCLI{

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

while (true) {
System.out.println("Welcome to Sorting and Searching Algorithm Simulator!");
System.out.println("1. Sorting Algorithms:"); System.out.println(" 1.1. Bubble Sort"); System.out.println(" 1.2. Selection Sort"); System.out.println(" 1.3. Insertion Sort"); System.out.println(" 1.4. Merge Sort"); System.out.println(" 1.5. Quick Sort"); System.out.println("2. Searching Algorithms:"); System.out.println(" 2.1. Linear Search");
System.out.println(" 2.2. Binary Search (requires sorted array)");
System.out.println("0. Exit"); System.out.print("Choose an option: "); int option = scanner.nextInt();
if (option == 0) { System.out.println("Exiting program..."); break;
}

switch (option) {
case 1:
performSortingOperations(scanner);
break; case 2:
performSearchingOperations(scanner);
break; default:
System.out.println("Invalid option. Please try again.");
break;
}
}
scanner.close();
}

private static void performSortingOperations(Scanner scanner) {
 
System.out.print("Enter the size of the data set: ");
int size = scanner.nextInt();
int[] dataSet = generateRandomArray(size);
long startTime, endTime;

System.out.println("Initial array: " + Arrays.toString(dataSet)); System.out.println("Choose a sorting algorithm:"); System.out.println("1. Bubble Sort");
System.out.println("2. Selection Sort"); System.out.println("3. Insertion Sort"); System.out.println("4. Merge Sort"); System.out.println("5. Quick Sort");

int sortOption = scanner.nextInt();
switch (sortOption) {
case 1:
System.out.println("Sorting with Bubble Sort..."); startTime = System.nanoTime(); bubbleSort(dataSet);
endTime = System.nanoTime(); break;
case 2:
System.out.println("Sorting with Selection Sort..."); startTime = System.nanoTime(); selectionSort(dataSet);
endTime = System.nanoTime(); break;
case 3:
System.out.println("Sorting with Insertion Sort..."); startTime = System.nanoTime(); insertionSort(dataSet);
endTime = System.nanoTime(); break;
case 4:
System.out.println("Sorting with Merge Sort..."); startTime = System.nanoTime(); mergeSort(dataSet);
endTime = System.nanoTime(); break;
case 5:
System.out.println("Sorting with Quick Sort..."); startTime = System.nanoTime(); quickSort(dataSet);
endTime = System.nanoTime(); break;
default:
System.out.println("Invalid sorting option.");
return;
}
double executionTime = (endTime - startTime) / 1e6; // Convert nanoseconds to milliseconds System.out.println("Sorted array: " + Arrays.toString(dataSet)); System.out.println("Execution time: " + executionTime + " milliseconds");

switch (sortOption) {
case 1:
 
System.out.println("Time Complexity: O(n^2)"); System.out.println("Space Complexity: O(1)"); break;
case 2:
System.out.println("Time Complexity: O(n^2)"); System.out.println("Space Complexity: O(1)"); break;
case 3:
System.out.println("Time Complexity: O(n^2) - worst and average case, O(n) - best case");
System.out.println("Space Complexity: O(1)");
break; case 4:
System.out.println("Time Complexity: O(n log n)"); System.out.println("Space Complexity: O(n)"); break;
case 5:
System.out.println("Time Complexity: O(n log n) - average case, O(n^2) - worst case");
System.out.println("Space Complexity: O(log n)");
break;
}
System.out.println("	");
}

private static void performSearchingOperations(Scanner scanner) {
System.out.print("Enter the size of the data set: ");
int size = scanner.nextInt();
int[] dataSet = generateRandomArray(size);
long startTime, endTime;

System.out.println("Initial array: " + Arrays.toString(dataSet)); System.out.println("Choose a searching algorithm:"); System.out.println("1. Linear Search");
System.out.println("2. Binary Search (requires sorted array)");

int searchOption = scanner.nextInt(); System.out.print("Enter the target value to search: "); int target = scanner.nextInt();

switch (searchOption) {
case 1:
System.out.println("Searching with Linear Search..."); startTime = System.nanoTime();
int linearResult = linearSearch(dataSet, target); endTime = System.nanoTime();
if (linearResult != -1) {
System.out.println("Found at index: " + linearResult);
} else {
System.out.println("Element not found.");
}
System.out.println("Time Complexity: O(n)"); System.out.println("Space Complexity: O(1)"); break;
case 2:
mergeSort(dataSet); // Sort array before binary search
System.out.println("Sorted array: " + Arrays.toString(dataSet));
 
System.out.println("Searching with Binary Search..."); startTime = System.nanoTime();
int binaryResult = binarySearch(dataSet, target); endTime = System.nanoTime();
if (binaryResult != -1) {
System.out.println("Found at index: " + binaryResult);
} else {
System.out.println("Element not found.");
}
System.out.println("Time Complexity: O(log n)"); System.out.println("Space Complexity: O(1)"); break;
default:
System.out.println("Invalid searching option.");
return;
}

double executionTime = (endTime - startTime) / 1e6; // Convert nanoseconds to milliseconds System.out.println("Execution time: " + executionTime + " milliseconds"); System.out.println("	");
}
private static void bubbleSort(int[] arr) {
int n = arr.length;
for (int i = 0; i < n - 1; i++) {
for (int j = 0; j < n - i - 1; j++) {
if (arr[j] > arr[j + 1]) {
// Swap arr[j] and arr[j + 1]
int temp = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = temp;
}
}
}
}

private static void selectionSort(int[] arr) {
int n = arr.length;
for (int i = 0; i < n - 1; i++) {
int minIndex = i;
for (int j = i + 1; j < n; j++) {
if (arr[j] < arr[minIndex]) { minIndex = j;
}
}
// Swap arr[i] and arr[minIndex]
int temp = arr[i]; arr[i] = arr[minIndex]; arr[minIndex] = temp;
}
}

private static void insertionSort(int[] arr) {
int n = arr.length;
for (int i = 1; i < n; i++) {
int key = arr[i];
 
int j = i - 1;
while (j >= 0 && arr[j] > key) { arr[j + 1] = arr[j];
j--;
}
arr[j + 1] = key;
}
}
private static void mergeSort(int[] arr) {
mergeSortHelper(arr, 0, arr.length - 1);
}

private static void mergeSortHelper(int[] arr, int left, int right) {
if (left < right) {
int mid = left + (right - left) / 2; mergeSortHelper(arr, left, mid); mergeSortHelper(arr, mid + 1, right); merge(arr, left, mid, right);
}
}
private static void merge(int[] arr, int left, int mid, int right) {
int n1 = mid - left + 1; int n2 = right - mid; int[] L = new int[n1]; int[] R = new int[n2];

for (int i = 0; i < n1; i++) { L[i] = arr[left + i];
}
for (int j = 0; j < n2; j++) { R[j] = arr[mid + 1 + j];
}

int i = 0, j = 0;
int k = left;
while (i < n1 && j < n2) {
if (L[i] <= R[j]) {
arr[k] = L[i]; i++;
} else {
arr[k] = R[j]; j++;
} k++;
}

while (i < n1) { arr[k] = L[i]; i++;
k++;
}

while (j < n2) { arr[k] = R[j];
 
j++; k++;
}
}

private static void quickSort(int[] arr) {
quickSortHelper(arr, 0, arr.length - 1);
}
private static void quickSortHelper(int[] arr, int low, int high) {
if (low < high) {
int pi = partition(arr, low, high); quickSortHelper(arr, low, pi - 1); quickSortHelper(arr, pi + 1, high);
}
}

private static int partition(int[] arr, int low, int high) {
int pivot = arr[high];
int i = (low - 1);
for (int j = low; j < high; j++) {
if (arr[j] <= pivot) { i++;
int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
}
}
int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp; return i + 1;
}

private static int linearSearch(int[] arr, int target) {
for (int i = 0; i < arr.length; i++) {
if (arr[i] == target) {
return i;
}
}
return -1;
}
private static int binarySearch(int[] arr, int target) {
int left = 0, right = arr.length - 1;
while (left <= right) {
int mid = left + (right - left) / 2;
if (arr[mid] == target) {
return mid;
}
if (arr[mid] < target) { left = mid + 1;
} else {
right = mid - 1;
}
}
 
return -1;
}
private static int[] generateRandomArray(int size) {
int[] arr = new int[size]; for (int i = 0; i < size; i++) {
arr[i] = (int) (Math.random() * 100);
}
return arr;
}
}