#include <iostream>
#include <vector>
#include <cmath>
#include <cstdlib>
#include <cstdio>
using namespace std;

// Structure that represents point
struct Instance{
    int id;
    int cluster;
    vector<double> coordinates;
};

// All points
vector<Instance> instances;

// Parameters of algorithm
double eps = 30;
int minPts = 10;

bool Neibore(Instance p, Instance q);

// Determine if point is 'core'
bool Core(Instance p){
    int kol=0;
    for (int i=0; i < instances.size(); i++)
        if (Neibore(instances[i],p))
            kol+=1;
    return (kol >= minPts);
}

// Euclidian distance between points
double Distance(Instance p, Instance q) {
    int d = p.coordinates.size();
    double dist = 0;
    for(int i = 0; i < d; i++){
        dist += (p.coordinates[i] - q.coordinates[i]) * (p.coordinates[i] - q.coordinates[i]);
    }
    return sqrt(dist);
}

// Check if points are neighbours
bool Neibore(Instance p, Instance q){
    return (Distance(p,q) <= eps);
}

bool DirectlyDensityReached(Instance p, Instance q){
    if (p.id != q.id) return (Core(q) && Neibore(p,q));
    return false;
}

bool DensityReached(Instance p, Instance q){
    for (int i=0;i< instances.size();i++)
        if (instances[i].id != p.id && instances[i].id != q.id)
        if (DirectlyDensityReached(instances[i],p)&&
            DirectlyDensityReached(instances[i],q)||
            DirectlyDensityReached(p,q))
            return true;
    return false;
};

// Current cluster we assign
int current_cluster = 0;

// Main procedure of algo
void clustrize() {
    for (int i = 0; i < instances.size(); i++) // for every point
        if (instances[i].cluster == 0) //if it is not yet classified
            if (Core(instances[i])) { //if it is a core-point
                current_cluster++;
                for (int j = 0; j < instances.size(); j++) //collect all points density reached
                    if (DensityReached(instances[j], instances[i]))
                        instances[j].cluster = current_cluster;
            } else {
                instances[i].cluster = -1; //assign point to NOISE
            }
}

int main() {
    srand(2);

    // Generate test points
    // Firstly we randomly generate points that would be "pivot" of clusters
    // and then generate randomly points near pivot cluster point.
    // By adjusting max_offset we can experiment and create different set of points:
    // where clusters are distinguishable or merged into one

    // Num of points
    int n = 100;

    // Number of dimensions
    int d = 2;

    // Number of clusters to generate
    int c = 4;

    // Max coordinate for points
    int max_coordinate = 200;

    // Max offset from cluster pivot element
    int max_offset = 50;

    // Generate pivot points for clusters
    vector<vector<int> > cluster_centers;
    for(int i = 0; i < c; i++){
        vector<int> center;
        for(int j = 0; j < d; j++){
            center.push_back(rand() % max_coordinate);
        }
        cluster_centers.push_back(center);
    }

    // Generate points randomly with random
    for(int i = 0; i < n; i++){
        Instance p;
        p.coordinates.clear();
        p.cluster = 0;
        p.id = i;

        for(int j = 0; j < d; j++){
            p.coordinates.push_back(cluster_centers[i % c][j] + rand() % max_offset);
        }
        instances.push_back(p);

        cout << "point " << i << " " << p.coordinates[0] << " " << p.coordinates[1] << endl;
    }

    for(int k = 0; k < 10; k++){
        Instance p;
        p.coordinates.clear();
        p.cluster = 0;
        p.id = n+k;

        for(int j = 0; j < d; j++){
            p.coordinates.push_back(rand() % max_coordinate);
        }
        instances.push_back(p);
        cout << "point " << n+k << " " << p.coordinates[0] << " " << p.coordinates[1] << endl;
    }

    clustrize();

    cout << "Result " <<endl;
    for(int i = 0; i < instances.size(); i++){

        cout << "point " << instances[i].id << " " << instances[i].coordinates[0] << " " << instances[i].coordinates[1] << " cluster = " << instances[i].cluster << endl;
    }

    freopen("pts.txt", "w", stdout);
    cout << instances.size() << endl;
    for(int i = 0; i < instances.size(); i++){
        cout << instances[i].id << " " << instances[i].coordinates[0] << " " << instances[i].coordinates[1] << " " << instances[i].cluster << endl;
    }


    return 0;
}
