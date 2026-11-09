up:
	podman compose down
	podman compose up -d --build
down:
	podman compose down
logs:
	podman compose logs -f app
rebuild:
	podman compose down
	podman compose build --no-cache app
	podman compose up -d
reset-db:
	podman compose down -v