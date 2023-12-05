import os

BASE_DIRECTORY = "javamm-exercises\src\main\java\com\github\lorenzoyang"


def get_immediate_subdirectories(directory):
    subdirectories = [d for d in os.listdir(
        directory) if os.path.isdir(os.path.join(directory, d))]
    return subdirectories


def get_java_files_in_subdirectories(BASE_DIRECTORY, subdirectories):
    java_files = {}
    for subdir in subdirectories:
        subdir_path = os.path.join(BASE_DIRECTORY, subdir)
        java_files[subdir] = [f for f in os.listdir(
            subdir_path) if f.endswith(".java")]
    return java_files


if __name__ == "__main__":

    subdirectories = get_immediate_subdirectories(BASE_DIRECTORY)
    java_files_in_subdirectories = get_java_files_in_subdirectories(
        BASE_DIRECTORY, subdirectories)

print("\nJava files in each subdirectory:")
for subdir, files in java_files_in_subdirectories.items():
    print(f"{subdir}: {', '.join(files)}")
