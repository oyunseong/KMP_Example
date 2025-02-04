import SwiftUI
import shared

@main
struct iOSApp: App {
     
    init(){
        shared.KoinKt.doInitKoin()
    }
    
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
