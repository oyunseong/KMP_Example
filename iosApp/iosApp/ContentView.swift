import SwiftUI
import shared

struct ContentView: View {
    var body: some View {
        ComposeView()
                .ignoresSafeArea()
    } 
}


struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        return MainViewControllerKt.MainViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
        // 필요에 따라 뷰 컨트롤러 업데이트 (비워둘 수도 있음)
    }
}


struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}


