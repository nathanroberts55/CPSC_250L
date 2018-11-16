public class TwoDArrayMethods {
		public static int[][] transpose(int[][] array)
		{
		    int m = array.length;
		    int n = array[0].length;

		    int[][] transposedMatrix = new int[n][m];

		    for(int x = 0; x < n; x++)
		    {
		        for(int y = 0; y < m; y++)
		        {
		            transposedMatrix[x][y] = array[y][x];
		        }
		    }

		    return transposedMatrix;
		}
	}


