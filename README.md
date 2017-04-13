# K-Means-Cluster-Image-Compression

K-means clustering on images:
Image compression ratio for different values of K are reported below:

Koala.jpg: 

C:\Emkae\UTD\kmeans>javac KMeans.java
C:\Emkae\UTD\kmeans>java KMeans C:\Emkae\UTD\kmeans\Koala.jpg 2
Original Image:C:\Emkae\UTD\kmeans\Koala.jpg
Output Image:C:\Emkae\UTD\kmeans\Koala_output_k2.jpg
Image width:    1024
Image height:   768
Input Image size: 762.5302734375 KB
Output Image size: 127.1005859375 KB
Compression Ratio: 83.33173247476086

C:\Emkae\UTD\kmeans>java KMeans C:\Emkae\UTD\kmeans\Koala.jpg 5
Original Image:C:\Emkae\UTD\kmeans\Koala.jpg
Output Image:C:\Emkae\UTD\kmeans\Koala_output_k5.jpg
Image width:    1024
Image height:   768
Input Image size: 762.5302734375 KB
Output Image size: 171.5166015625 KB
Compression Ratio: 77.50691250731592

C:\Emkae\UTD\kmeans>java KMeans C:\Emkae\UTD\kmeans\Koala.jpg 10
Original Image:C:\Emkae\UTD\kmeans\Koala.jpg
Output Image:C:\Emkae\UTD\kmeans\Koala_output_k10.jpg
Image width:    1024
Image height:   768
Input Image size: 762.5302734375 KB
Output Image size: 159.583984375 KB
Compression Ratio: 79.0717837790764

C:\Emkae\UTD\kmeans>java KMeans C:\Emkae\UTD\kmeans\Koala.jpg 15
Original Image:C:\Emkae\UTD\kmeans\Koala.jpg
Output Image:C:\Emkae\UTD\kmeans\Koala_output_k15.jpg
Image width:    1024
Image height:   768
Input Image size: 762.5302734375 KB
Output Image size: 153.81640625 KB
Compression Ratio: 79.82815743739683

C:\Emkae\UTD\kmeans>java KMeans C:\Emkae\UTD\kmeans\Koala.jpg 20
Original Image:C:\Emkae\UTD\kmeans\Koala.jpg
Output Image:C:\Emkae\UTD\kmeans\Koala_output_k20.jpg
Image width:    1024
Image height:   768
Input Image size: 762.5302734375 KB
Output Image size: 151.9404296875 KB
Compression Ratio: 80.07417738281396


Penguins.jpg :

C:\Emkae\UTD\kmeans>java KMeans C:\Emkae\UTD\kmeans\Penguins.jpg 2
Original Image:C:\Emkae\UTD\kmeans\Penguins.jpg
Output Image:C:\Emkae\UTD\kmeans\Penguins_output_k2.jpg
Image width:    1024
Image height:   768
Input Image size: 759.6044921875 KB
Output Image size: 83.0205078125 KB
Compression Ratio : 89.0705612372804

C:\Emkae\UTD\kmeans>java KMeans C:\Emkae\UTD\kmeans\Penguins.jpg 5
Original Image:C:\Emkae\UTD\kmeans\Penguins.jpg
Output Image:C:\Emkae\UTD\kmeans\Penguins_output_k5.jpg
Image width:    1024
Image height:   768
Input Image size: 759.6044921875 KB
Output Image size: 108.158203125 KB
Compression Ratio : 85.76124756535769

C:\Emkae\UTD\kmeans>java KMeans C:\Emkae\UTD\kmeans\Penguins.jpg 10
Original Image:C:\Emkae\UTD\kmeans\Penguins.jpg
Output Image:C:\Emkae\UTD\kmeans\Penguins_output_k10.jpg
Image width:    1024
Image height:   768
Input Image size: 759.6044921875 KB
Output Image size: 112.92578125 KB
Compression Ratio : 85.13360802740941

C:\Emkae\UTD\kmeans>java KMeans C:\Emkae\UTD\kmeans\Penguins.jpg 15
Original Image:C:\Emkae\UTD\kmeans\Penguins.jpg
Output Image:C:\Emkae\UTD\kmeans\Penguins_output_k15.jpg
Image width:    1024
Image height:   768
Input Image size: 759.6044921875 KB
Output Image size: 111.8984375 KB
Compression Ratio: 85.2688552199374

C:\Emkae\UTD\kmeans>java KMeans C:\Emkae\UTD\kmeans\Penguins.jpg 20
Original Image:C:\Emkae\UTD\kmeans\Penguins.jpg
Output Image:C:\Emkae\UTD\kmeans\Penguins_output_k20.jpg
Image width:    1024
Image height:   768
Input Image size: 759.6044921875 KB
Output Image size: 112.259765625 KB
Compression Ratio: 85.22128729100645


There is a trade-off between Quality of Image and the compression ratio. The main aim is to reconstruct the original data exactly from the compressed representation without any loss of data rather than more compression.




