import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(new int[] { i + 1, Integer.parseInt(st.nextToken()) });
		}
		
		int pos = 0;
		
		while(!list.isEmpty()) {
			int[] current = list.remove(pos);	//터뜨린 풍선 위치 저장
			bw.write(current[0]+" ");	//위치 출력
			if (list.isEmpty()) break;
			
			int move = current[1]; //적혀있던 숫자
			int size = list.size();
			
			if (move > 0) {
			    pos = (pos + (move - 1)) % size;
			} else {
			    pos = (pos + move + size) % size;
			}
		}
		bw.flush();
		bw.close();
			}
		}